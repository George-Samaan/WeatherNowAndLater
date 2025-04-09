package com.vodafonetask.data.local

interface CityLocalDataSource {
    fun saveCity(cityName: String)
    fun getLastCity(): String
}