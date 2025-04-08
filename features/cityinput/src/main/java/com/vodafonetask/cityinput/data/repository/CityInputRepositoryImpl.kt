package com.vodafonetask.cityinput.data.repository

import com.vodafonetask.cityinput.domain.repository.CityInputRepository
import javax.inject.Inject

class CityInputRepositoryImpl @Inject constructor() : CityInputRepository {
    private var lastCity = ""

    override fun saveLastSearchedCity(cityName: String) {
        lastCity = cityName
    }

    override fun getLastSearchedCity(): String {
        return lastCity
    }
}