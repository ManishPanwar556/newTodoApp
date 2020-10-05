package com.example.todoapp.viewModel


import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.repository.TaskRepository
import com.example.todoapp.room.Task


class TaskViewModel(context: Context) : ViewModel() {

    lateinit var property: LiveData<List<Task>>

    val taskRepo = TaskRepository(context)

    init {
        property = getAllData()
    }

    fun insertData(task: String, description: String) {
        taskRepo.insertData(Task(task = task, description = description))
        property=getAllData()
    }

    fun getAllData() = taskRepo.getAllData()

    fun deleteData(task: Task){
        taskRepo.deleteData(task)
    }
}