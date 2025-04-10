package com.vodafonetask.forecast.data.domain.model


data class ForecastInfo(
    val dateTime: String,
    val temperature: Double,
    val condition: String,
    val iconUrl: String
)