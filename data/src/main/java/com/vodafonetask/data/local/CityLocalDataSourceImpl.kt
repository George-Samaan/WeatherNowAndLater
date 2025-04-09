package com.vodafonetask.data.local

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject

class CityLocalDataSourceImpl @Inject constructor(private val sharedPreferences: SharedPreferences) :
    CityLocalDataSource {
    companion object {
        private const val KEY_LAST_CITY = "last_city_name"
    }

    override fun saveCity(cityName: String) {
        sharedPreferences.edit() { putString(KEY_LAST_CITY, cityName) }
    }

    override fun getLastCity(): String {
        return sharedPreferences.getString(KEY_LAST_CITY, "").toString()
    }
}