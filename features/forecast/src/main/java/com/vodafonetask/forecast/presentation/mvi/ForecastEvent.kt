package com.vodafonetask.forecast.presentation.mvi

sealed class ForecastEvent{
    data class LoadForecast(val city: String) : ForecastEvent()
}