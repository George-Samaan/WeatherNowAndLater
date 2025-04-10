package com.vodafonetask.forecast.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vodafonetask.forecast.data.domain.model.DailyForecast

@Composable
fun ForecastItem(forecast: DailyForecast) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Day: ${forecast.dayOfWeek}")
            Text(text = "Min Temp: ${forecast.minTemp}°C")
            Text(text = "Max Temp: ${forecast.maxTemp}°C")
            Text(text = "Condition: ${forecast.condition}")
        }
    }
}