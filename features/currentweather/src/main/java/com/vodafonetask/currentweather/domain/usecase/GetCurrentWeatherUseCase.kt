package com.vodafonetask.currentweather.domain.usecase

import com.vodafonetask.currentweather.domain.model.WeatherInfo
import com.vodafonetask.currentweather.domain.repo.CurrentWeatherRepo
import javax.inject.Inject

class GetCurrentWeatherUseCase @Inject constructor(
    private val repository: CurrentWeatherRepo
) {
    suspend operator fun invoke(city: String): WeatherInfo {
        return repository.getCurrentWeather(city)
    }
}