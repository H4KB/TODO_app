package com.h4kb.todo.model

import android.text.TextUtils
import java.util.*

class TaskModel(
        val taskType: TaskType,
        val id: Int,
        var name: String,
        private val deadline: Calendar,
) {
    private val createdAt by lazy { Calendar.getInstance() }
    val formattedCreatedAt: String = "${createdAt.get(Calendar.YEAR)}/${createdAt.get(Calendar.MONTH)}/${createdAt.get(Calendar.DATE)}"

    init {
        if (TextUtils.isEmpty(name)) {
            name = "無題のタスク"
        }
    }

    fun formattedUntil(): String {
        val now = Calendar.getInstance()
        now.set(Calendar.HOUR, 0)
        now.set(Calendar.MINUTE, 0)
        now.set(Calendar.MILLISECOND, 0)
        val diff = this.deadline.timeInMillis - now.timeInMillis
        val remainingDays: Int = (diff / (24 * 60 * 60 * 1000)).toInt()
        return "あと${ remainingDays }日"
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}