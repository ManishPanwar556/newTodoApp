package com.example.todoapp.viewModel


import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.todoapp.repository.TaskRepository
import com.example.todoapp.room.TaskEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


class TaskViewModel @ViewModelInject constructor(
    private val taskRepo: TaskRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {


    var property: LiveData<List<TaskEntity>>


    init {
       property=taskRepo.getAllTask()
    }

    fun insertData(task: String, description: String) {
       viewModelScope.launch(Dispatchers.IO) {
               taskRepo.insertTask(TaskEntity(task = task, description = description))
               property=taskRepo.getAllTask()
       }

    }

    fun getAllData() = taskRepo.getAllTask()

    fun deleteData(taskEntity: TaskEntity){
        viewModelScope.launch (Dispatchers.IO){
            taskRepo.deleteTask(taskEntity)
            property=taskRepo.getAllTask()
        }

    }
}