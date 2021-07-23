package com.h4kb.todo.model

import android.text.TextUtils
import java.util.*

class TaskModel(
        val taskType: TaskType,
        val id: Int,
        var name: String,
        val until: Calendar,
) {
    private val createdAt by lazy { Calendar.getInstance() }
    val formattedCreatedAt: String = "${createdAt.get(Calendar.YEAR)}/${createdAt.get(Calendar.MONTH)}/${createdAt.get(Calendar.DATE)}"

    init {
        if (TextUtils.isEmpty(name)) {
            name = "無題のタスク"
        }
    }

    fun formattedUntil(): String {
        println(until)
        println(Calendar.getInstance())
        val remainingTime = this.until.compareTo(Calendar.getInstance())
        println(remainingTime)
        val remainingDays: Int = remainingTime / (24 * 60 * 60)
        return "あと${ remainingDays }日"
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}