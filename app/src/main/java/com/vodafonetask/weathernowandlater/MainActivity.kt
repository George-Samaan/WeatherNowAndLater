package com.vodafonetask.weathernowandlater

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vodafonetask.cityinput.presentation.ui.CityInputScreen
import com.vodafonetask.currentweather.presentation.ui.CurrentWeatherScreen
import com.vodafonetask.weathernowandlater.ui.theme.WeatherNowAndLaterTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherNowAndLaterTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "cityInput") {
                    composable("cityInput") {
                        CityInputScreen { cityName ->
                            navController.navigate("currentWeather/$cityName")
                        }
                    }

                    composable("currentWeather/{city}") { backStackEntry ->
                        val cityName = backStackEntry.arguments?.getString("city")
                        if (cityName != null) {
                            CurrentWeatherScreen(city = cityName)
                        }
                    }
                }
            }
        }
    }
}