package com.example.todoapp.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: TaskEntity)

    @Delete
    suspend fun deleteTask(task: TaskEntity)

    @Query("Select *from todo_table order by id desc")
    fun getAllTask(): LiveData<List<TaskEntity>>

}