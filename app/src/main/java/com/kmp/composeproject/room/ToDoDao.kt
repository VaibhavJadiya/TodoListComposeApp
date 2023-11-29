package com.kmp.composeproject.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kmp.composeproject.data.models.ToDoDataClass
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    //custom Query functions
    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllTasks(): Flow<List<ToDoDataClass>>

    @Query("SELECT *  FROM todo_table WHERE id=:taskId")
    fun getSelectedTask(taskId:Int): Flow<ToDoDataClass>

    //Room Pre Made functions
     @Insert(onConflict = OnConflictStrategy.IGNORE)
     suspend fun addTask(toDoDataClass: ToDoDataClass)

     @Update
     suspend fun updateTask(toDoDataClass: ToDoDataClass)

     @Delete
     suspend fun deleteTask(toDoDataClass: ToDoDataClass)

     @Query("DELETE FROM todo_table")
     suspend fun deleteAllTask()

     @Query("SELECT  * FROM todo_table WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
     fun searchDatabase(searchQuery:String) : Flow<List<ToDoDataClass>>

     @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
     fun sortByLowPriority(): Flow<List<ToDoDataClass>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    fun sortByHighPriority(): Flow<List<ToDoDataClass>>


    //use Flow to make a function run with coroutines
     //if used suspension then it makes it run in coroutines only
     // so either it's suspend function or a function that returns Flow :)
}