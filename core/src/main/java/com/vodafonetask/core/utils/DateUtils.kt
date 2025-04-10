package com.vodafonetask.core.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun String.toDayOfWeek(): String {
    println("DATE INPUT: $this")
    return try {
        val parser = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val date = parser.parse(this)
        val formatter = SimpleDateFormat("EEEE", Locale.getDefault())
        formatter.format(date ?: Date())
    } catch (e: Exception) {
        println("Date parsing failed: ${e.message}")
        "Unknown"
    }
}