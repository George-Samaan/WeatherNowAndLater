package com.vodafonetask.core.utils

import androidx.annotation.DrawableRes
import com.vodafonetask.core.R

@DrawableRes
fun getCustomIconForWeather(iconCode: String): Int {
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