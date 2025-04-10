package com.vodafonetask.forecast.data.domain.repo

import com.vodafonetask.forecast.data.domain.model.DailyForecast

interface ForecastRepository {
    suspend fun getForecast(city: String): List<DailyForecast>
}