package com.vodafonetask.forecast.data.domain.repo

import com.vodafonetask.forecast.data.domain.model.ForecastInfo

interface ForecastRepository {
    suspend fun getForecast(city: String): List<ForecastInfo>
}