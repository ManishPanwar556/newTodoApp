package com.example.todoapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.R
import com.example.todoapp.adapter.MyAdapter
import com.example.todoapp.adapter.RecyclerViewClickInterface
import com.example.todoapp.room.TaskEntity
import com.example.todoapp.viewModel.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_appbar.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), RecyclerViewClickInterface {
private val viewModel:TaskViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener {
            MyBottomSheet().show(supportFragmentManager, "")
        }
        viewModel.property.observe(this, Observer {

             val adapter=MyAdapter(it,this)
            if(adapter.itemCount!=0){
                rev.visibility=View.VISIBLE
                text2.visibility= View.GONE
                image.visibility=View.GONE

            }
            else{
                rev.visibility=View.GONE
                text2.visibility= View.VISIBLE
                image.visibility=View.VISIBLE
            }
             rev.adapter=adapter

             rev.layoutManager=LinearLayoutManager(this)
        })

    }

    override fun onClick(position: Int,task: TaskEntity) {
        viewModel.deleteData(task)
        Toast.makeText(this,"Task Deleted Successfully",Toast.LENGTH_SHORT).show()
    }

}