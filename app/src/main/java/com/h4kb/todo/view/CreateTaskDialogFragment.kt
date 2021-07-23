package com.h4kb.todo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.h4kb.todo.databinding.DialogCreateTaskBinding
import com.h4kb.todo.viewModel.ToDoListViewModel

class CreateTaskDialogFragment : BottomSheetDialogFragment() {
    private  val viewModel: ToDoListViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DialogCreateTaskBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }
}