package com.vodafonetask.currentweather.presentation.ui

import com.vodafonetask.currentweather.domain.model.WeatherInfo

sealed class CurrentWeatherState {
    data object Loading : CurrentWeatherState()
    data class Success(val weather: WeatherInfo) : CurrentWeatherState()
    data class Error(val message: String) : CurrentWeatherState()
    data object Empty : CurrentWeatherState()
}