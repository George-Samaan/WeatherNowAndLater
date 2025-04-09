package com.vodafonetask.currentweather.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

data class WeatherApiResponse(
    val main: Main,
    val weather: List<Weather>
)

data class Main(
    val temp: Double
)

data class Weather(
    val main: String,
    val icon: String
)

interface WeatherApiService {
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): WeatherApiResponse
}