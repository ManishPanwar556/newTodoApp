package com.example.todoapp.adapter

import com.example.todoapp.room.Task

interface RecyclerViewClickInterface {
    fun onClick(position:Int,task: Task)
}