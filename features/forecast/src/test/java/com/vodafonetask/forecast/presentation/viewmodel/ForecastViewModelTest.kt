package com.vodafonetask.forecast.presentation.viewmodel

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.vodafonetask.forecast.domain.model.DailyForecast
import com.vodafonetask.forecast.domain.usecase.GetForecastUseCase
import com.vodafonetask.forecast.presentation.mvi.ForecastEvent
import com.vodafonetask.forecast.presentation.mvi.ForecastState
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
class ForecastViewModelTest {

    private val useCase = mock<GetForecastUseCase>()
    private lateinit var viewModel: ForecastViewModel
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = ForecastViewModel(useCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `load forecast emits Loading then Success`() = runTest {
        val fakeData = listOf(
            DailyForecast(
                dayOfWeek = "Thursday",
                minTemp = 10.0,
                maxTemp = 20.0,
                condition = "Clear",
                iconUrl = "https://dummy.com/icon.png"
            )
        )

        whenever(useCase("Cairo")).thenReturn(fakeData)

        viewModel.state.test {
            // Initial state emitted by MutableStateFlow
            val initialState = awaitItem()
            assertThat(initialState).isInstanceOf(ForecastState.Empty::class.java)

            viewModel.onEvent(ForecastEvent.LoadForecast("Cairo"))

            testDispatcher.scheduler.advanceUntilIdle()

            // Next state: Loading
            val loadingState = awaitItem()
            assertThat(loadingState).isInstanceOf(ForecastState.Loading::class.java)

            // Next state: Success
            val successState = awaitItem()
            assertThat(successState).isInstanceOf(ForecastState.Success::class.java)
            val forecastList = (successState as ForecastState.Success).forecast
            assertThat(forecastList).isEqualTo(fakeData)

            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `load forecast emits Loading then Error`() = runTest {
        val errorMessage = "API Error"
        whenever(useCase("Cairo")).thenThrow(RuntimeException(errorMessage))

        viewModel.state.test {
            // Initial state emitted by MutableStateFlow
            val initialState = awaitItem()
            assertThat(initialState).isInstanceOf(ForecastState.Empty::class.java)

            viewModel.onEvent(ForecastEvent.LoadForecast("Cairo"))

            testDispatcher.scheduler.advanceUntilIdle()

            // Next state: Loading
            val loadingState = awaitItem()
            assertThat(loadingState).isInstanceOf(ForecastState.Loading::class.java)

            // Next state: Error
            val errorState = awaitItem()
            assertThat(errorState).isInstanceOf(ForecastState.Error::class.java)
            assertThat((errorState as ForecastState.Error).message).contains("API Error")

            cancelAndIgnoreRemainingEvents()
        }
    }
}