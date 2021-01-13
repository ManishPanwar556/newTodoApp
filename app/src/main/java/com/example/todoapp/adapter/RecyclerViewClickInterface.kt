package com.example.todoapp.adapter

import com.example.todoapp.room.TaskEntity

interface RecyclerViewClickInterface {
    fun onClick(position:Int,task: TaskEntity)
}