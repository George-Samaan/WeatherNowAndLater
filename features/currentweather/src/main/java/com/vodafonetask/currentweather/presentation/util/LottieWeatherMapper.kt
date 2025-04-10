package com.vodafonetask.currentweather.presentation.util

import android.content.Context
import com.vodafonetask.currentweather.R

fun getLottieAnimationRes(context: Context, description: String): Int {
    return when (description.lowercase()) {
        context.getString(R.string.clear_sky) -> R.raw.clear_sky_anim
        context.getString(R.string.few_clouds) -> R.raw.few_clouds
        context.getString(R.string.scattered_clouds) -> R.raw.scattered_clouds_anim
        context.getString(R.string.broken_clouds) -> R.raw.broken_cloud_anim
        context.getString(R.string.overcast_clouds) -> R.raw.overcast_clouds_anim
        context.getString(R.string.light_intensity_shower_rain) -> R.raw.rain_anim
        context.getString(R.string.light_rain) -> R.raw.rain_anim
        context.getString(R.string.moderate_rain) -> R.raw.rain_anim
        context.getString(R.string.light_snow) -> R.raw.snow_anim
        context.getString(R.string.snow) -> R.raw.snow_anim
        context.getString(R.string.thunderstorm) -> R.raw.thunderstorm
        context.getString(R.string.mist) -> R.raw.mist
        else -> R.raw.clear_sky_anim
    }
}