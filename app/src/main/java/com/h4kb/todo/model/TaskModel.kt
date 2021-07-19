package com.h4kb.todo.model

import java.util.*

class TaskModel(
        val taskType: TaskType,
        val id: Int,
        var name: String,
        val until: Calendar,
) {
    private val createdAt by lazy { Calendar.getInstance() }
    val formattedCreatedAt: String = "${createdAt.get(Calendar.YEAR)}/${createdAt.get(Calendar.MONTH)}/${createdAt.get(Calendar.DATE)}"

    fun formattedUntil(): String {
        val remainingTime = this.createdAt.compareTo(Calendar.getInstance())
        val remainingDays: Int = remainingTime / (24 * 60 * 60)
        return "あと${ remainingDays }日"
    }
}