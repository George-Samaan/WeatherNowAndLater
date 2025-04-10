package com.vodafonetask.currentweather.presentation.util

import com.vodafonetask.currentweather.R

fun getLottieAnimationRes(description: String): Int {
    return when (description.lowercase()) {
        "clear sky", "clear" -> R.raw.clear_sky_anim
        "few clouds" -> R.raw.few_clouds
        "scattered clouds" -> R.raw.scattered_clouds_anim
        "broken clouds" -> R.raw.broken_cloud_anim
        "overcast clouds" -> R.raw.overcast_clouds_anim
        "light intensity shower rain" -> R.raw.rain_anim
        "light rain" -> R.raw.rain_anim
        "moderate rain" -> R.raw.rain_anim
        "light snow" -> R.raw.snow_anim
        "snow" -> R.raw.snow_anim
        "thunderstorm" -> R.raw.thunderstorm
        "mist" -> R.raw.mist
        else -> R.raw.clear_sky_anim
    }
}