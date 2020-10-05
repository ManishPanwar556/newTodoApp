package com.example.todoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todoapp.R
import com.example.todoapp.viewModel.TaskViewModel

import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet.view.*

class MyBottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val taskViewModel= TaskViewModel(requireContext())
        val view = inflater.inflate(R.layout.bottom_sheet, container, false)
        view.savebtn.setOnClickListener {
            val task=view.taskEditText.text.toString()
            val description=view.descriptionEditText.text.toString()
            taskViewModel.insertData(task,description)
            dismiss()
        }
        return view
    }




}