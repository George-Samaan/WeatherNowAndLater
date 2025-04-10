package com.vodafonetask.data.remote


import com.vodafonetask.data.remote.api.WeatherApiService
import com.vodafonetask.data.remote.dto.ForecastApiDto
import com.vodafonetask.data.remote.dto.WeatherApiDto
import javax.inject.Inject
import javax.inject.Named

class WeatherRemoteDataSourceImpl @Inject constructor(
    private val api: WeatherApiService,
    @Named("weather_api_key") private val apiKey: String
) : WeatherRemoteDataSource {

    override suspend fun getCurrentWeather(city: String): WeatherApiDto {
        return api.getCurrentWeather(city, apiKey)
    }

    override suspend fun getForecast(city: String): ForecastApiDto {
        return api.getForecast(city, apiKey)
    }
}