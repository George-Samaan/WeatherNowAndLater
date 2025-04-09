package com.vodafonetask.cityinput.domain.usecase.lastcity

import com.vodafonetask.cityinput.domain.repo.CityInputRepository
import javax.inject.Inject

class GetLastCityUseCase @Inject constructor(
    private val repository: CityInputRepository
) {
    operator fun invoke(): String? {
        return repository.getLastCity()
    }
}