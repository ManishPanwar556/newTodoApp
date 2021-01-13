package com.example.todoapp.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Long=0L,
    val task: String,
    val description: String
)