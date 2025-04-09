package com.vodafonetask.cityinput.domain.repo

interface CityInputRepository {
    fun saveCity(city: String)
    fun getLastCity(): String?
}