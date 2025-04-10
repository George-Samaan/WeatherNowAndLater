package com.vodafonetask.forecast.data.mapper

import com.google.common.truth.Truth.assertThat
import com.vodafonetask.data.remote.dto.ForecastApiDto
import com.vodafonetask.data.remote.dto.ForecastItemDto
import com.vodafonetask.data.remote.dto.MainDto
import com.vodafonetask.data.remote.dto.WeatherDescriptionDto
import com.vodafonetask.forecast.domain.model.DailyForecast
import org.junit.Test
import java.util.Locale

class ForecastMapperTest {

    @Test
    fun `mapToDailyForecastList maps correctly to domain model`() {
        // Given
        val input = ForecastApiDto(
            list = listOf(
                ForecastItemDto(
                    dt = 1692534400,
                    dt_txt = "2023-08-20 09:00:00",
                    main = MainDto(temp = 22.5),
                    weather = listOf(WeatherDescriptionDto(main = "Clouds", icon = "02d"))
                ),
                ForecastItemDto(
                    dt = 1692545200,
                    dt_txt = "2023-08-20 12:00:00",
                    main = MainDto(temp = 25.0),
                    weather = listOf(WeatherDescriptionDto(main = "Clouds", icon = "02d"))
                ),
                ForecastItemDto(
                    dt = 1692556000,
                    dt_txt = "2023-08-21 09:00:00",
                    main = MainDto(temp = 18.0),
                    weather = listOf(WeatherDescriptionDto(main = "Rain", icon = "10d"))
                ),
                ForecastItemDto(
                    dt = 1692566800,
                    dt_txt = "2023-08-21 15:00:00",
                    main = MainDto(temp = 26.0),
                    weather = listOf(WeatherDescriptionDto(main = "Clear", icon = "01d"))
                )
            )
        )

        // When
        val result: List<DailyForecast> = input.mapToDailyForecastList()

        // Then
        assertThat(result).hasSize(2)

        val day1 = result[0]
        assertThat(day1.dayOfWeek.lowercase(Locale.getDefault())).isEqualTo("sunday")
        assertThat(day1.minTemp).isEqualTo(22.5)
        assertThat(day1.maxTemp).isEqualTo(25.0)
        assertThat(day1.condition).isEqualTo("Clouds")
        assertThat(day1.iconUrl).isEqualTo("02d")

        val day2 = result[1]
        assertThat(day2.dayOfWeek.lowercase(Locale.getDefault())).isEqualTo("monday")
        assertThat(day2.minTemp).isEqualTo(18.0)
        assertThat(day2.maxTemp).isEqualTo(26.0)
        assertThat(day2.condition).isEqualTo("Rain")
        assertThat(day2.iconUrl).isEqualTo("10d")
    }

    @Test
    fun `mapToDailyForecastList handles empty list`() {
        val input = ForecastApiDto(list = emptyList())

        val result = input.mapToDailyForecastList()

        assertThat(result).isEmpty()
    }

    @Test
    fun `mapToDailyForecastList handles missing weather data`() {
        val input = ForecastApiDto(
            list = listOf(
                ForecastItemDto(
                    dt = 1692534400,
                    dt_txt = "2023-08-22 09:00:00",
                    main = MainDto(temp = 20.0),
                    weather = emptyList()
                )
            )
        )

        val result = input.mapToDailyForecastList()

        assertThat(result).hasSize(1)
        val day = result[0]
        assertThat(day.condition).isEqualTo("Unknown")
        assertThat(day.iconUrl).isEqualTo("01d")
    }
}