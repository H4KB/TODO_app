package com.h4kb.todo.model

import java.util.*

class TaskModel(
        val taskType: TaskType,
        val id: Int,
        var name: String,
        val until: Date,
) {
    private val createdAt: Calendar = Calendar.getInstance()
    val formattedCreateAt = "${createdAt.get(Calendar.YEAR)}/${createdAt.get(Calendar.MONTH)}/${createdAt.get(Calendar.DATE)}"
}