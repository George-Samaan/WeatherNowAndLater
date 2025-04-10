package com.vodafonetask.core.utils

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun WeatherImage(iconCode: String, modifier: Modifier = Modifier) {
    val iconRes = getCustomIconForWeather(iconCode)
    Image(
        painter = painterResource(id = iconRes),
        contentDescription = "weather icon",
        modifier = modifier
    )
}