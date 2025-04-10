package com.vodafonetask.currentweather.presentation.ui

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun WeatherImage(url: String) {
    AsyncImage(
        model = url,
        contentDescription = "Weather icon",
        modifier = Modifier.size(10.dp)
    )
}