package com.vodafonetask.data.remote

import com.vodafonetask.data.remote.dto.ForecastApiDto
import com.vodafonetask.data.remote.dto.WeatherApiDto


interface WeatherRemoteDataSource {
    suspend fun getCurrentWeather(city: String): WeatherApiDto
    suspend fun getForecast(city: String): ForecastApiDto
}