package com.vodafonetask.forecast.data.repo

import com.vodafonetask.data.remote.WeatherRemoteDataSource
import com.vodafonetask.forecast.data.domain.model.DailyForecast
import com.vodafonetask.forecast.data.domain.repo.ForecastRepository
import com.vodafonetask.forecast.data.mapper.mapToDailyForecastList
import javax.inject.Inject

class ForecastRepositoryImpl @Inject constructor(
    private val remoteDataSource: WeatherRemoteDataSource,
) : ForecastRepository {

    override suspend fun getForecast(city: String): List<DailyForecast> {
        val forecast = remoteDataSource.getForecast(city)
        return forecast.mapToDailyForecastList()
    }
}