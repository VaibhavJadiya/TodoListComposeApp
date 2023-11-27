package com.kmp.composeproject.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kmp.composeproject.utils.Constants

@Entity(tableName = Constants.DATABASE_TABLE)
data class ToDoDataClass(

    @PrimaryKey(autoGenerate = true)
    val id :Int=0,
    val title:String,
    val description:String,
    val priority: Priority

)
