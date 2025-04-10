package com.vodafonetask.currentweather.data.mapper

import com.vodafonetask.currentweather.domain.model.WeatherInfo
import com.vodafonetask.data.remote.dto.WeatherApiDto

fun WeatherApiDto.mapToWeatherInfo(): WeatherInfo {
    return WeatherInfo(
        temperature = main.temp,
        condition = weather.firstOrNull()?.description.orEmpty(),
        iconUrl = weather.firstOrNull()?.icon.orEmpty()
    )
}