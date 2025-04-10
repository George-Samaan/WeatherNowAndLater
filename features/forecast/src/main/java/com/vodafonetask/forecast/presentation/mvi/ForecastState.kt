package com.vodafonetask.forecast.presentation.mvi

import com.vodafonetask.forecast.data.domain.model.ForecastInfo

sealed class ForecastState {
    data object Loading : ForecastState()
    data class Success(val forecast: List<ForecastInfo>) : ForecastState()
    data class Error(val message: String) : ForecastState()
    data object Empty : ForecastState()

}