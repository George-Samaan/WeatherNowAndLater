package com.vodafonetask.cityinput.domain.repository

interface CityInputRepository {
    fun saveLastSearchedCity(cityName: String)
    fun getLastSearchedCity(): String
}