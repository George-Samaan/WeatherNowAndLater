package com.vodafonetask.forecast.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vodafonetask.forecast.data.domain.usecase.GetForecastUseCase
import com.vodafonetask.forecast.presentation.mvi.ForecastEffect
import com.vodafonetask.forecast.presentation.mvi.ForecastEvent
import com.vodafonetask.forecast.presentation.mvi.ForecastState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val getForecastUseCase: GetForecastUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<ForecastState>(ForecastState.Empty)
    val state: MutableStateFlow<ForecastState> = _state

    private val _effect = Channel<ForecastEffect>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

    fun onEvent(event: ForecastEvent) {
        when (event) {
            is ForecastEvent.LoadForecast -> loadForecast(event.city)
        }
    }

    fun loadForecast(city: String) {
        viewModelScope.launch {
            _state.value = ForecastState.Loading

            try {
                val forecast = getForecastUseCase(city)
                if (forecast.isEmpty()) {
                    _state.value = ForecastState.Empty
                } else {
                    _state.value = ForecastState.Success(forecast)
                }
            } catch (e: Exception) {
                _state.value = ForecastState.Error(e.message ?: "Unknown error")
                _effect.send(ForecastEffect.ShowError(e.message ?: "Unknown error"))
            }
        }
    }
}