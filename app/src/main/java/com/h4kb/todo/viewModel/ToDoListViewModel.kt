package com.h4kb.todo.viewModel

import android.widget.CalendarView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.h4kb.todo.model.TaskModel
import com.h4kb.todo.model.TaskType
import java.text.SimpleDateFormat
import java.util.*

class ToDoListViewModel : ViewModel() {
    private val taskRow = mutableListOf<TaskModel>()
    private val _tasks by lazy { MutableLiveData<List<TaskModel>>() }
    val tasks = _tasks
    private var _taskDeadline = Calendar.getInstance()

    fun addTask(taskName: String) {
        val task = TaskModel(TaskType.TODO, (Math.random() * 10).toInt(), taskName, _taskDeadline)
        taskRow.add(task)
        _tasks.value = taskRow
    }

    fun setTaskDeadline(deadline: Calendar) {
        _taskDeadline = deadline
    }
}