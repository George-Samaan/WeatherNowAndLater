package com.vodafonetask.forecast.data.domain.usecase

import com.vodafonetask.forecast.data.domain.model.DailyForecast
import com.vodafonetask.forecast.data.domain.repo.ForecastRepository
import javax.inject.Inject

class GetForecastUseCase @Inject constructor(
    private val repository: ForecastRepository
){
    suspend operator fun invoke(city: String) : List<DailyForecast> {
        return repository.getForecast(city)
    }
}