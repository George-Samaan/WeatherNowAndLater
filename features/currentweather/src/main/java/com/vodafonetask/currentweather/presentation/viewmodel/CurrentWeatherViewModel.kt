package com.vodafonetask.currentweather.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vodafonetask.currentweather.domain.usecase.GetCurrentWeatherUseCase
import com.vodafonetask.currentweather.presentation.ui.CurrentWeatherState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<CurrentWeatherState>(CurrentWeatherState.Empty)
    val state: StateFlow<CurrentWeatherState> = _state

    fun loadWeather(city: String) {
        viewModelScope.launch {
            _state.value = CurrentWeatherState.Loading
            try {
                val result = getCurrentWeatherUseCase(city)
                _state.value = CurrentWeatherState.Success(result)
            } catch (e: Exception) {
                _state.value = CurrentWeatherState.Error(e.message ?: "Unknown error")
            }
        }
    }
}