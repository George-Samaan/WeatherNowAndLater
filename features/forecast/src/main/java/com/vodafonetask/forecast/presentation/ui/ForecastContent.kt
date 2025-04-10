package com.vodafonetask.forecast.presentation.ui

import androidx.compose.runtime.Composable
import com.vodafonetask.forecast.presentation.mvi.ForecastState

@Composable
fun ForecastContent(state: ForecastState) {
    when (state) {
        is ForecastState.Loading -> ForecastLoadingView()
        is ForecastState.Error -> ForecastErrorView(state.message)
        is ForecastState.Empty -> ForecastEmptyView()
        is ForecastState.Success -> ForecastSuccessView(state.forecast)
    }
}