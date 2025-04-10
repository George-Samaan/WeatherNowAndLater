package com.vodafonetask.forecast.data.di

import com.vodafonetask.data.remote.WeatherRemoteDataSource
import com.vodafonetask.forecast.data.repo.ForecastRepositoryImpl
import com.vodafonetask.forecast.domain.repo.ForecastRepository
import com.vodafonetask.forecast.domain.usecase.GetForecastUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ForecastModule {
    @Provides
    @Singleton
    fun provideForecastRepository(remoteDataSource: WeatherRemoteDataSource): ForecastRepository {
        return ForecastRepositoryImpl(remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideGetForecastUseCase(repository: ForecastRepository): GetForecastUseCase {
        return GetForecastUseCase(repository)
    }
}