package com.vodafonetask.currentweather.domain.model

data class WeatherInfo(
    val temperature: Double,
    val condition: String,
    val iconUrl: String
)