package com.vodafonetask.weathernowandlater.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vodafonetask.cityinput.presentation.ui.CityInputScreen
import com.vodafonetask.weathernowandlater.ui.CombinedWeatherScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "cityInput") {

        composable(
            route = "cityInput",
            enterTransition = { fadeIn(animationSpec = tween(300)) },
            exitTransition = { fadeOut(animationSpec = tween(300)) })
        {
            CityInputScreen { cityName ->
                navController.navigate("combinedScreen/$cityName")
            }
        }

        composable(
            route = "combinedScreen/{city}",
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { it },
                    animationSpec = tween(500)
                )
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -it },
                    animationSpec = tween(500)
                )
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -it }, animationSpec = tween(500)
                )
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { it },
                    animationSpec = tween(500)
                )
            }
        ) { backStackEntry ->
            val city = backStackEntry.arguments?.getString("city") ?: return@composable
            CombinedWeatherScreen(city)
        }
    }
}