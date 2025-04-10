package com.vodafonetask.data.remote.dto

data class WeatherApiDto(
    val main: Main,
    val weather: List<Weather>
)

data class Main(
    val temp: Double
)

data class Weather(
    val main: String,
    val icon: String
)