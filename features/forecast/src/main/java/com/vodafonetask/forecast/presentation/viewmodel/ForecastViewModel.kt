package com.vodafonetask.forecast.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vodafonetask.forecast.domain.model.DailyForecast
import com.vodafonetask.forecast.domain.usecase.GetForecastUseCase
import com.vodafonetask.forecast.presentation.mvi.ForecastEffect
import com.vodafonetask.forecast.presentation.mvi.ForecastEvent
import com.vodafonetask.forecast.presentation.mvi.ForecastIntent
import com.vodafonetask.forecast.presentation.mvi.ForecastState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val getForecastUseCase: GetForecastUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<ForecastState>(ForecastState.Empty)
    val state: StateFlow<ForecastState> = _state.asStateFlow()

    private val _effect = MutableSharedFlow<ForecastEffect>()
    val effect: SharedFlow<ForecastEffect> = _effect.asSharedFlow()

    fun onEvent(event: ForecastEvent) {
        when (event) {
            is ForecastEvent.LoadForecast -> {
                handleIntent(ForecastIntent.LoadForecast(event.city))
            }
        }
    }

    private fun handleIntent(intent: ForecastIntent) {
        when (intent) {
            is ForecastIntent.LoadForecast -> loadForecast(intent.city)
        }
    }

    private fun loadForecast(city: String) {
        viewModelScope.launch {
            _state.value = ForecastState.Loading
            try {
                val forecastList: List<DailyForecast> = getForecastUseCase(city)
                _state.value = if (forecastList.isNotEmpty()) {
                    ForecastState.Success(forecastList)
                } else {
                    ForecastState.Empty
                }
            } catch (e: Exception) {
                _state.value = ForecastState.Error(e.message ?: "Unknown error")
                _effect.emit(ForecastEffect.ShowError(e.message ?: "Something went wrong"))
            }
        }
    }
}