package com.vodafonetask.forecast.domain.repo

import com.vodafonetask.forecast.domain.model.DailyForecast

interface ForecastRepository {
    suspend fun getForecast(city: String): List<DailyForecast>
}