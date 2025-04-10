package com.vodafonetask.forecast.data.domain.usecase

import com.vodafonetask.forecast.data.domain.model.ForecastInfo
import com.vodafonetask.forecast.data.domain.repo.ForecastRepository
import javax.inject.Inject

class GetForecastUseCase @Inject constructor(
    private val repository: ForecastRepository
){
    suspend operator fun invoke(city: String) : List<ForecastInfo> {
        return repository.getForecast(city)
    }
}