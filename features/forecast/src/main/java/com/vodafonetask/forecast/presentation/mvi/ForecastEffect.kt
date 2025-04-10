package com.vodafonetask.forecast.presentation.mvi

sealed class ForecastEffect {
    data class ShowError(val message: String) : ForecastEffect()
}