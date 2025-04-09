package com.vodafonetask.data.remote

import com.vodafonetask.data.remote.model.WeatherApiDto


interface WeatherRemoteDataSource {
    suspend fun getCurrentWeather(city: String): WeatherApiDto
}