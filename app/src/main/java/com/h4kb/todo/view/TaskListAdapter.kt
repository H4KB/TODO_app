package com.h4kb.todo.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.h4kb.todo.databinding.TaskItemBinding
import com.h4kb.todo.model.TaskModel

class TaskListAdapter(private val viewLifeCycleOwner: LifecycleOwner) : ListAdapter<TaskModel, TaskListAdapter.TaskListViewHolder>(TaskDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TaskItemBinding.inflate(inflater, parent, false)
        return TaskListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {
        val task = getItem(position)
        if (task != null) {
            holder.bind(task, viewLifeCycleOwner)
        }
    }

    class TaskListViewHolder(private val binding: TaskItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(taskModel: TaskModel, viewLifeCycleOwner: LifecycleOwner) {
            binding.run {
                lifecycleOwner = viewLifeCycleOwner
                task = taskModel
                executePendingBindings()
            }
        }
    }
}

private class TaskDiffCallBack: DiffUtil.ItemCallback<TaskModel>() {
    override fun areItemsTheSame(oldItem: TaskModel, newItem: TaskModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TaskModel, newItem: TaskModel): Boolean {
        return oldItem == newItem
    }
}