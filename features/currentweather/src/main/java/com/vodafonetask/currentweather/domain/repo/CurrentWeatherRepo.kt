package com.vodafonetask.currentweather.domain.repo

import com.vodafonetask.currentweather.domain.model.WeatherInfo

interface CurrentWeatherRepo {
    suspend fun getCurrentWeather(city: String): WeatherInfo
}