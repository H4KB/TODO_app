package com.h4kb.todo.model

import java.util.*

data class TaskModel(
        val taskType: TaskType,
        val id: Int,
        val name: String,
        val until: Date,
        val createAt: Date,
        val updateAt: Date
)