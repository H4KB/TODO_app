package com.h4kb.todo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.h4kb.todo.databinding.DialogCreateTaskBinding
import com.h4kb.todo.viewModel.ToDoListViewModel
import java.util.*

class CreateTaskDialogFragment : BottomSheetDialogFragment() {
    private  val viewModel: ToDoListViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DialogCreateTaskBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel

        binding.calendarView.setOnDateChangeListener{_, year, month, dayOfMonth ->
            val deadline = Calendar.getInstance()
            deadline.set(Calendar.YEAR, year)
            deadline.set(Calendar.MONTH, month)
            deadline.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            viewModel.setTaskDeadline(deadline)
        }

        return binding.root
    }
}