package com.vodafonetask.data.remote.dto

data class ForecastApiDto(
    val list: List<ForecastItemDto>
)

data class ForecastItemDto(
    val dt: Long,
    val main: MainDto,
    val weather: List<WeatherDescriptionDto>
)

data class MainDto(
    val temp: Double
)

data class WeatherDescriptionDto(
    val main: String,
    val icon: String
)