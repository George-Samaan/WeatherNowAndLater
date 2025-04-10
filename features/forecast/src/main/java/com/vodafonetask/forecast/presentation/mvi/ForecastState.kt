package com.vodafonetask.forecast.presentation.mvi

import com.vodafonetask.forecast.data.domain.model.DailyForecast

sealed class ForecastState {
    data object Loading : ForecastState()
    data class Success(val forecast: List<DailyForecast>) : ForecastState()
    data class Error(val message: String) : ForecastState()
    data object Empty : ForecastState()

}