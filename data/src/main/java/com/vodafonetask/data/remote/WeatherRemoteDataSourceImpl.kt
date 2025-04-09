package com.vodafonetask.data.remote


import com.vodafonetask.data.remote.api.WeatherApiService
import com.vodafonetask.data.remote.model.WeatherApiDto
import javax.inject.Inject
import javax.inject.Named

class WeatherRemoteDataSourceImpl @Inject constructor(
    private val api: WeatherApiService,
    @Named("weather_api_key") private val apiKey: String
) : WeatherRemoteDataSource {
    override suspend fun getCurrentWeather(city: String): WeatherApiDto {
        return api.getCurrentWeather(city, apiKey)
    }
}