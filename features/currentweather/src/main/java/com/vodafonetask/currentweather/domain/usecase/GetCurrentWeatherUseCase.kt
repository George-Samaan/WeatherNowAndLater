package com.vodafonetask.currentweather.domain.usecase

import com.vodafonetask.currentweather.domain.model.WeatherInfo
import com.vodafonetask.currentweather.domain.repository.WeatherRepository
import javax.inject.Inject

class GetCurrentWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
){
    suspend operator fun invoke(city: String): WeatherInfo {
        return repository.getCurrentWeather(city)
    }
}