package com.h4kb.todo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.h4kb.todo.databinding.FragmentToDoListBinding
import com.h4kb.todo.viewModel.ToDoListViewModel

class ToDoListFragment : Fragment() {
    private val viewModel: ToDoListViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val binding = FragmentToDoListBinding.inflate(inflater, container, false)
        context ?: return binding.root

        binding.viewModel = viewModel
        binding.toDoList.layoutManager = LinearLayoutManager(context)
        binding.toDoList.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        val taskListAdapter = TaskListAdapter(viewLifecycleOwner)
        binding.toDoList.adapter = taskListAdapter

        viewModel.tasks.observe(viewLifecycleOwner, {
            taskListAdapter.submitList(it.toMutableList())
        })

        return binding.root
    }
}