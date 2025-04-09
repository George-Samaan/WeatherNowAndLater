package com.vodafonetask.currentweather.data.repo

import com.vodafonetask.currentweather.data.mapper.mapToWeatherInfo
import com.vodafonetask.currentweather.domain.model.WeatherInfo
import com.vodafonetask.currentweather.domain.repo.CurrentWeatherRepo
import com.vodafonetask.data.remote.WeatherRemoteDataSource
import javax.inject.Inject


class CurrentCurrentWeatherRepoImpl @Inject constructor(
    private val remoteDataSource: WeatherRemoteDataSource
) : CurrentWeatherRepo {
    override suspend fun getCurrentWeather(city: String): WeatherInfo {
        return remoteDataSource.getCurrentWeather(city).mapToWeatherInfo()
    }
}