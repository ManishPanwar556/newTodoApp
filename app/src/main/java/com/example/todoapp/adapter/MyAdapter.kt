package com.example.todoapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.room.TaskEntity
import kotlinx.android.synthetic.main.row_item.view.*

class MyAdapter (val data:List<TaskEntity>, val recyclerViewClickInterface: RecyclerViewClickInterface):RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    inner class MyViewHolder(val view: View):RecyclerView.ViewHolder(view){
        init {
            view.checkbox.setOnClickListener {
                if(adapterPosition!=RecyclerView.NO_POSITION) {
                    recyclerViewClickInterface.onClick(adapterPosition,data.get(adapterPosition))
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.row_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.view.task.text=data.get(position).task
        holder.view.description.text=data.get(position).description
    }

    override fun getItemCount(): Int {
        return data.size
    }


}