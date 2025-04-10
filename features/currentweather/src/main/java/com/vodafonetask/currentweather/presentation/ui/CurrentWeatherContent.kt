package com.vodafonetask.currentweather.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vodafonetask.currentweather.domain.model.WeatherInfo

@Composable
fun CurrentWeatherContent(
    city: String,
    weather : WeatherInfo
){
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp , vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = city, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        WeatherImage(iconCode = weather.iconUrl)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "${weather.temperature}°C", style = MaterialTheme.typography.headlineLarge)
        Text(text = weather.condition, style = MaterialTheme.typography.bodyLarge)
    }
}