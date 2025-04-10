package com.vodafonetask.currentweather.presentation.viewmodel

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.vodafonetask.currentweather.domain.model.WeatherInfo
import com.vodafonetask.currentweather.domain.usecase.GetCurrentWeatherUseCase
import com.vodafonetask.currentweather.presentation.ui.CurrentWeatherState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class CurrentWeatherViewModelTest {

    private val getCurrentWeatherUseCase = mock<GetCurrentWeatherUseCase>()
    private lateinit var viewModel: CurrentWeatherViewModel
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = CurrentWeatherViewModel(getCurrentWeatherUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loadWeather emits Loading then Success`() = runTest {
        val dummyWeather = WeatherInfo(
            temperature = 25.0,
            condition = "Clear",
            iconUrl = "https://dummy.com/icon.png"
        )
        whenever(getCurrentWeatherUseCase("Cairo")).thenReturn(dummyWeather)

        viewModel.state.test {
            viewModel.loadWeather("Cairo")
            testDispatcher.scheduler.advanceUntilIdle()

            skipItems(1) // Skip initial Empty state

            val first = awaitItem()
            assertThat(first).isInstanceOf(CurrentWeatherState.Loading::class.java)

            val second = awaitItem()
            assertThat(second).isInstanceOf(CurrentWeatherState.Success::class.java)

            val weather = (second as CurrentWeatherState.Success).weather
            assertThat(weather.temperature).isEqualTo(25.0)
            assertThat(weather.condition).isEqualTo("Clear")
            assertThat(weather.iconUrl).isEqualTo("https://dummy.com/icon.png")

            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `loadWeather emits Loading then Error`() = runTest {
        whenever(getCurrentWeatherUseCase("Cairo")).thenThrow(RuntimeException("API Error"))

        viewModel.state.test {
            viewModel.loadWeather("Cairo")
            testDispatcher.scheduler.advanceUntilIdle()

            skipItems(1) // Skip initial Empty state

            val first = awaitItem()
            assertThat(first).isInstanceOf(CurrentWeatherState.Loading::class.java)

            val second = awaitItem()
            assertThat(second).isInstanceOf(CurrentWeatherState.Error::class.java)
            assertThat((second as CurrentWeatherState.Error).message).contains("API Error")

            cancelAndIgnoreRemainingEvents()
        }
    }
}