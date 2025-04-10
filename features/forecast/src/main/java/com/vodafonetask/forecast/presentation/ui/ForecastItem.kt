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
import com.vodafonetask.forecast.data.domain.model.ForecastInfo

@Composable
fun ForecastItem(forecast: ForecastInfo) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Time: ${forecast.dateTime}")
            Text(text = "Temperature: ${forecast.temperature}°C")
            Text(text = "Condition: ${forecast.condition}")
        }
    }
}