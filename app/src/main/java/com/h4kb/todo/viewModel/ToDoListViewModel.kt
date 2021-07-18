package com.h4kb.todo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.distinctUntilChanged
import com.h4kb.todo.model.TaskModel
import com.h4kb.todo.model.TaskType
import java.util.*

class ToDoListViewModel : ViewModel() {
    private val taskRow = mutableListOf<TaskModel>()
    private val _tasks by lazy { MutableLiveData<List<TaskModel>>() }
    val tasks = _tasks

    fun addTask() {
        val cal = Calendar.getInstance()
        val task = TaskModel(TaskType.TODO, (Math.random() * 10).toInt(), "hello", cal.time, cal.time, cal.time)

        taskRow.add(task.copy())
        _tasks.value = taskRow
    }
}