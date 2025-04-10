package com.vodafonetask.weathernowandlater.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vodafonetask.currentweather.presentation.ui.CurrentWeatherScreen
import com.vodafonetask.forecast.presentation.ui.ForecastScreen

@Composable
fun CombinedWeatherScreen(city: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        CurrentWeatherScreen(city = city)
        ForecastScreen(city = city)
    }
}