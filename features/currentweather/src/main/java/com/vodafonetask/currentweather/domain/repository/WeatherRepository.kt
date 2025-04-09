package com.vodafonetask.currentweather.domain.repository

import com.vodafonetask.currentweather.domain.model.WeatherInfo

interface WeatherRepository {
    suspend fun getCurrentWeather(city: String): WeatherInfo
}