package com.example.todoapp.repository

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import com.example.todoapp.room.Task
import com.example.todoapp.room.TaskDao
import com.example.todoapp.room.TaskDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class TaskRepository(context: Context){
    private var taskDao:TaskDao= TaskDatabase.getInstance(context)!!.taskDao

    private lateinit var allTask:LiveData<List<TaskDao>>

    fun getAllData():LiveData<List<Task>>{
        lateinit var task: LiveData<List<Task>>
        task=taskDao.getAllTask()
        return task
    }
    fun insertData(task: Task){
        GlobalScope.launch(Dispatchers.IO) {
            taskDao.insertTask(task)
        }
    }
    fun deleteData(task: Task){
        GlobalScope.launch(Dispatchers.IO) {
            taskDao.deleteTask(task)
        }
    }
}