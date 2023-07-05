package com.example.nycschools.utils

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale


fun Date.format(format: String = "MM-dd-yyyy hh:mm:ss"): String {
    val simpleDate = SimpleDateFormat(format, Locale.ENGLISH)
    val currentDate = simpleDate.format(this)
    return currentDate
}

fun String.toDateTime(format: String = "MM-dd-yyyy hh:mm:ss"): LocalDateTime? {
    return try {
        val pattern = DateTimeFormatter.ofPattern(format)
        val localDateTime = LocalDateTime.parse(this, pattern)
        localDateTime
    } catch (e: Exception) {
        null
    }
}