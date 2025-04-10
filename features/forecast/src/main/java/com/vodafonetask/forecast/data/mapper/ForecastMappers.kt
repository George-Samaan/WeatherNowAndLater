package com.vodafonetask.forecast.data.mapper

import com.vodafonetask.data.remote.dto.ForecastApiDto
import com.vodafonetask.forecast.domain.model.DailyForecast
import java.text.SimpleDateFormat
import java.util.Locale

fun ForecastApiDto.mapToDailyForecastList(): List<DailyForecast> {
    val dateFormatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    val dayFormatter = SimpleDateFormat("EEEE", Locale.getDefault())

    // Group by day name
    val groupedByDay = list.groupBy {
        val date = dateFormatter.parse(it.dt_txt)
        dayFormatter.format(date ?: return@groupBy "Unknown")
    }

    return groupedByDay.map { (day, forecasts) ->
        val minTemp = forecasts.minOf { it.main.temp }
        val maxTemp = forecasts.maxOf { it.main.temp }

        // Get the most frequent weather condition
        val condition = forecasts
            .mapNotNull { it.weather.firstOrNull()?.main }
            .groupingBy { it }
            .eachCount()
            .maxByOrNull { it.value }
            ?.key ?: "Unknown"

        val iconCode = forecasts
            .mapNotNull { it.weather.firstOrNull()?.icon }
            .groupingBy { it }
            .eachCount()
            .maxByOrNull { it.value }
            ?.key ?: "01d"

        DailyForecast(
            dayOfWeek = day,
            minTemp = minTemp,
            maxTemp = maxTemp,
            condition = condition,
            iconUrl = iconCode
        )
    }
}