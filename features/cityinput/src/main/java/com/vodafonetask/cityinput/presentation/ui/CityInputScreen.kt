package com.vodafonetask.cityinput.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vodafonetask.cityinput.presentation.viewmodel.CityInputViewModel


@Composable
fun CityInputScreen(
    viewModel: CityInputViewModel = hiltViewModel(),
    onSearchClicked: (String) -> Unit,
) {
    val cityName by viewModel.cityName.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
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
            singleLine = true
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
