package com.vodafonetask.currentweather.data.repository

import com.vodafonetask.currentweather.data.remote.WeatherApiService
import com.vodafonetask.currentweather.domain.model.WeatherInfo
import com.vodafonetask.currentweather.domain.repository.WeatherRepository
import javax.inject.Inject
import javax.inject.Named

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApiService,
    @Named("weather_api_key") private val apiKey: String
) : WeatherRepository {
    override suspend fun getCurrentWeather(city: String): WeatherInfo {
        val response = api.getCurrentWeather(city, apiKey)

        return WeatherInfo(
            temperature = response.main.temp,
            condition = response.weather[0].main,
            iconUrl = "https://openweathermap.org/img/wn/${response.weather.firstOrNull()?.icon}@2x.png"
        )
    }
}