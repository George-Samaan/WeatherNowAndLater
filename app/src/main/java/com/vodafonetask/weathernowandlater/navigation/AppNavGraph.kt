package com.vodafonetask.weathernowandlater.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vodafonetask.cityinput.presentation.ui.CityInputScreen
import com.vodafonetask.weathernowandlater.ui.CombinedWeatherScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "cityInput") {

        composable("cityInput") {
            CityInputScreen { cityName ->
                navController.navigate("combinedScreen/$cityName")
            }
        }

        composable(route = "combinedScreen/{city}") { backStackEntry ->
            val city = backStackEntry.arguments?.getString("city") ?: return@composable
            CombinedWeatherScreen(city)
        }
    }
}