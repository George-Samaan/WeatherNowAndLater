package com.vodafonetask.currentweather.data.mapper

import com.google.common.truth.Truth.assertThat
import com.vodafonetask.data.remote.dto.Main
import com.vodafonetask.data.remote.dto.Weather
import com.vodafonetask.data.remote.dto.WeatherApiDto
import org.junit.Test

class WeatherMapperTest {

    @Test
    fun `mapToWeatherInfo maps WeatherApiDto to WeatherInfo correctly`() {
        // Given
        val dto = WeatherApiDto(
            main = Main(temp = 30.0),
            weather = listOf(
                Weather(
                    main = "Clear",
                    description = "Sunny",
                    icon = "01d"
                )
            )
        )

        // When
        val result = dto.mapToWeatherInfo()

        // Then
        assertThat(result.temperature).isEqualTo(30.0)
        assertThat(result.condition).isEqualTo("Sunny")
        assertThat(result.iconUrl).isEqualTo("01d")
    }

    @Test
    fun `mapToWeatherInfo handles empty weather list safely`() {
        // Given
        val dto = WeatherApiDto(
            main = Main(temp = 22.0),
            weather = emptyList() // edge case
        )

        // When
        val result = dto.mapToWeatherInfo()

        // Then
        assertThat(result.temperature).isEqualTo(22.0)
        assertThat(result.condition).isEqualTo("") // default if weather[0] doesn't exist
        assertThat(result.iconUrl).isEqualTo("")   // from `firstOrNull()?.icon.orEmpty()`
    }
}