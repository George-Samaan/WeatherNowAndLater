package com.vodafonetask.forecast.data.repo

import com.vodafonetask.data.remote.WeatherRemoteDataSource
import com.vodafonetask.forecast.data.domain.model.ForecastInfo
import com.vodafonetask.forecast.data.domain.repo.ForecastRepository
import com.vodafonetask.forecast.data.mapper.mapToListOfForecastInfo
import javax.inject.Inject

class ForecastRepositoryImpl @Inject constructor(
    private val remoteDataSource: WeatherRemoteDataSource,
) : ForecastRepository {

    override suspend fun getForecast(city: String): List<ForecastInfo> {
        return remoteDataSource.getForecast(city).mapToListOfForecastInfo()
    }
}