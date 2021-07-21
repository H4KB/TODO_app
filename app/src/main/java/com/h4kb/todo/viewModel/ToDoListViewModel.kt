package com.h4kb.todo.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.h4kb.todo.model.TaskModel
import com.h4kb.todo.model.TaskType
import java.util.*

class ToDoListViewModel : ViewModel() {
    private val taskRow = mutableListOf<TaskModel>()
    private val _tasks by lazy { MutableLiveData<List<TaskModel>>() }
    val tasks = _tasks

    val isCreateTaskDialogVisible: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)

    fun openCreateTaskDialog() {
        isCreateTaskDialogVisible.value = true;
    }

    fun closeCreateTaskDialog() {
        isCreateTaskDialogVisible.value = false
    }

    fun addTask() {
        val cal = Calendar.getInstance()
        val task = TaskModel(TaskType.TODO, (Math.random() * 10).toInt(), "hello", cal)

        taskRow.add(task)
        _tasks.value = taskRow
    }
}