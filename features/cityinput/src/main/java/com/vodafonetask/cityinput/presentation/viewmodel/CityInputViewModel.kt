package com.vodafonetask.cityinput.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vodafonetask.cityinput.domain.usecase.lastcity.GetLastCityUseCase
import com.vodafonetask.cityinput.domain.usecase.savecity.SaveCityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityInputViewModel @Inject constructor(
    private val saveCityUseCase: SaveCityUseCase,
    private val getLastCityUseCase: GetLastCityUseCase
) : ViewModel() {

    private val _cityName = MutableStateFlow("")
    val cityName: StateFlow<String> = _cityName

    init {
        viewModelScope.launch {
            _cityName.value = getLastCityUseCase()
        }
    }

    fun onCityChanged(newCity: String) {
        _cityName.value = newCity
    }

    fun onSearchClicked(): String {
        val cityName = _cityName.value.trim()
        saveCityUseCase(cityName)
        _cityName.value = ""
        return cityName
    }
}