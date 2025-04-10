package com.vodafonetask.forecast.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.vodafonetask.forecast.presentation.mvi.ForecastEffect
import com.vodafonetask.forecast.presentation.mvi.ForecastEvent
import com.vodafonetask.forecast.presentation.viewmodel.ForecastViewModel
import kotlinx.coroutines.flow.collectLatest


@Composable
fun ForecastScreen(
    city: String,
    viewModel: ForecastViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.effect.collectLatest { effect ->
            if (effect is ForecastEffect.ShowError) {
                println("Error: ${effect.message}")
            }
        }
    }

    LaunchedEffect(city) {
        viewModel.onEvent(ForecastEvent.LoadForecast(city))
    }

    ForecastContent(state)
}