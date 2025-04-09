package com.vodafonetask.currentweather.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
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

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (state) {
            is CurrentWeatherState.Loading -> {
                CircularProgressIndicator()
            }

            is CurrentWeatherState.Error -> {
                Text(
                    text = (state as CurrentWeatherState.Error).message
                )
            }

            is CurrentWeatherState.Success -> {
                val weather = (state as CurrentWeatherState.Success).weather
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "City: $city", style = MaterialTheme.typography.headlineSmall)
                    Text(text = "Temperature: ${weather.temperature}°C")
                    Text(text = "Condition: ${weather.condition}")
                    Spacer(modifier = Modifier.height(16.dp))
                    AsyncImage(
                        model = weather.iconUrl,
                        contentDescription = "Weather icon"
                    )
                }

            }

            is CurrentWeatherState.Empty -> {
                Text(text = "Waiting for city input...")

            }
        }
    }
}