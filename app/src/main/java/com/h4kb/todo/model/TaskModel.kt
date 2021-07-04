package com.h4kb.todo.model

import android.provider.ContactsContract
import java.util.*

data class TaskModel(
        val taskType: TaskType,
        val taskName: String,
        val until: Date,
        val createAt: Date,
        val updateAt: Date
)