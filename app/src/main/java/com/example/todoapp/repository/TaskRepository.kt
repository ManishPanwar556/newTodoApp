package com.example.todoapp.repository

import androidx.lifecycle.LiveData
import com.example.todoapp.room.TaskDao
import com.example.todoapp.room.TaskEntity
import javax.inject.Inject
class TaskRepository @Inject constructor(private val taskDao: TaskDao){
     fun getAllTask(): LiveData<List<TaskEntity>> {
        return taskDao.getAllTask()
    }
    suspend fun insertTask(taskEntity: TaskEntity){
        taskDao.insertTask(taskEntity)
    }
    suspend fun deleteTask(taskEntity: TaskEntity){
        taskDao.deleteTask(taskEntity)
    }

}