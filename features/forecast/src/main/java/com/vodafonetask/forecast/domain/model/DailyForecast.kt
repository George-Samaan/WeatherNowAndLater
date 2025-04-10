package com.vodafonetask.forecast.domain.model

data class DailyForecast(
    val dayOfWeek: String,
    val minTemp: Double,
    val maxTemp: Double,
    val condition: String,
    val iconUrl: String
)
