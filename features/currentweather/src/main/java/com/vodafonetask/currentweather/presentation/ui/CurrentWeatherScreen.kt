package com.vodafonetask.currentweather.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.vodafonetask.currentweather.presentation.viewmodel.CurrentWeatherViewModel

@Composable
fun CurrentWeatherScreen(
    city: String,
    viewModel: CurrentWeatherViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadWeather(city)
    }

    when (val currentState = state) {
        is CurrentWeatherState.Loading -> WeatherLoadingState()
        is CurrentWeatherState.Error -> WeatherErrorState(currentState.message)
        is CurrentWeatherState.Empty -> WeatherEmptyState()
        is CurrentWeatherState.Success -> CurrentWeatherContent(city, currentState.weather)
    }
}
