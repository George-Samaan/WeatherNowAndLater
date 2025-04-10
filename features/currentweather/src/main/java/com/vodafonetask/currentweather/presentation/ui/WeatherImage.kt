package com.vodafonetask.currentweather.presentation.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vodafonetask.currentweather.R

@Composable
fun WeatherImage(iconCode: String) {
    val iconRes = getCustomIconForWeather(iconCode)
    Image(
        painter = painterResource(id = iconRes),
        contentDescription = "weather icon",
        modifier = Modifier.size(48.dp)
    )
}

@DrawableRes
private fun getCustomIconForWeather(iconCode: String): Int {
    return when (iconCode) {
        "01d", "01n" -> R.drawable.ic_clear_sky
        "02d", "02n" -> R.drawable.ic_few_cloud
        "03d", "03n" -> R.drawable.ic_scattered_clouds
        "04d", "04n" -> R.drawable.ic_broken_clouds
        "09d", "09n" -> R.drawable.ic_shower_rain
        "10d", "10n" -> R.drawable.ic_rain
        "11d", "11n" -> R.drawable.ic_thunderstorm
        "13d", "13n" -> R.drawable.ic_snow
        "50d", "50n" -> R.drawable.ic_mist
        else -> R.drawable.ic_clear_sky
    }
}