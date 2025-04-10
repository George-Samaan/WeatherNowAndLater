package com.vodafonetask.forecast.data.mapper

import com.vodafonetask.data.remote.dto.ForecastApiDto
import com.vodafonetask.forecast.data.domain.model.ForecastInfo

fun ForecastApiDto.mapToListOfForecastInfo(): List<ForecastInfo> {
    return list.map {
        ForecastInfo(
            dateTime = it.dt.toString(),
            temperature = it.main.temp,
            condition = it.weather.firstOrNull()?.main.orEmpty(),
            iconUrl = "https://openweathermap.org/img/wn/${it.weather.firstOrNull()?.icon}@2x.png"
        )
    }
}