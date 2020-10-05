package com.example.todoapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {
    @Insert
    suspend fun insertTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("Select *from todo_table where id=:ind")
    suspend fun getTask(ind: Long): Task

    @Query("Select *from todo_table order by id desc")
    fun getAllTask(): LiveData<List<Task>>

}