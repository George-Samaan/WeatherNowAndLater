package com.vodafonetask.forecast.presentation.mvi

sealed class ForecastIntent {
    data class LoadForecast(val city: String) : ForecastIntent()
}