package com.vodafonetask.cityinput.data.repo

import com.vodafonetask.cityinput.domain.repo.CityInputRepository
import com.vodafonetask.data.local.CityLocalDataSource
import javax.inject.Inject

class CityInputRepositoryImpl @Inject constructor(
    private val localDataSource: CityLocalDataSource
) : CityInputRepository {

    override fun saveCity(city: String) {
        localDataSource.saveCity(city)
    }

    override fun getLastCity(): String? {
        return localDataSource.getLastCity()
    }
}