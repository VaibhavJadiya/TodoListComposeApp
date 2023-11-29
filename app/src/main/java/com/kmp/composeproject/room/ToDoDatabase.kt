package com.kmp.composeproject.room

import androidx.room.Database
import com.kmp.composeproject.data.models.ToDoDataClass

@Database(entities = [ToDoDataClass::class], version = 1 , exportSchema = false)
abstract class ToDoDatabase {
    abstract fun toDoDow():ToDoDataClass
}