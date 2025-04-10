package com.vodafonetask.data.remote.api

import com.vodafonetask.data.remote.dto.ForecastApiDto
import com.vodafonetask.data.remote.dto.WeatherApiDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): WeatherApiDto

    @GET("forecast")
    suspend fun getForecast(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): ForecastApiDto
}