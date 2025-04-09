package com.vodafonetask.cityinput.presentation.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.vodafonetask.cityinput.presentation.viewmodel.CityInputViewModel


@Composable
fun CityInputScreen(
    viewModel: CityInputViewModel = hiltViewModel(),
    onSearchClicked: (String) -> Unit,
) {
    val cityName by viewModel.cityName.collectAsState()
    val cityToNavigate by viewModel.navigateToWeather.collectAsState()

    LaunchedEffect(cityToNavigate) {
        cityToNavigate?.let {
            onSearchClicked(it)
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center,
    ) {
        AnimatedVisibility(
            visible = true,
            enter = slideInVertically() + fadeIn(),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Enter City Name",
                    style = MaterialTheme.typography.headlineSmall
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = cityName,
                    onValueChange = { viewModel.onCityChanged(it) },
                    label = { Text("City Name") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.padding(24.dp))

                Button(
                    onClick = { onSearchClicked(viewModel.onSearchClicked()) },
                    enabled = cityName.isNotBlank(),
                ) {
                    Text("Search")
                }
            }
        }
    }
}
