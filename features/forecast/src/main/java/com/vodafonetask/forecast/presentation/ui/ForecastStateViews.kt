package com.vodafonetask.forecast.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vodafonetask.forecast.domain.model.DailyForecast

@Composable
fun ForecastLoadingView(){
    Box(modifier = Modifier.fillMaxSize() , contentAlignment = Alignment.Center){
        CircularProgressIndicator()
    }
}

@Composable
fun ForecastErrorView(message: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = message)
    }
}

@Composable
fun ForecastEmptyView() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "No forecast available")
    }
}

@Composable
fun ForecastSuccessView(forecastList: List<DailyForecast>) {
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(forecastList.size) { index ->
            ForecastItem(forecastList[index])
        }
    }
}