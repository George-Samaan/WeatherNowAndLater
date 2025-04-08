package com.vodafonetask.cityinput.domain.usecase.savecity

import com.vodafonetask.cityinput.domain.repository.CityInputRepository
import javax.inject.Inject

class SaveCityUseCase @Inject constructor(
    private val repository: CityInputRepository
) {
    operator fun invoke(cityName: String) {
        repository.saveLastSearchedCity(cityName)
    }
}