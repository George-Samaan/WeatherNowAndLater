package com.vodafonetask.currentweather.di

import com.vodafonetask.currentweather.data.repo.CurrentCurrentWeatherRepoImpl
import com.vodafonetask.currentweather.domain.repo.CurrentWeatherRepo
import com.vodafonetask.currentweather.domain.usecase.GetCurrentWeatherUseCase
import com.vodafonetask.data.remote.WeatherRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CurrentWeatherModule {
    @Provides
    @Singleton
    fun provideWeatherRepo(remoteDataSource: WeatherRemoteDataSource): CurrentWeatherRepo {
        return CurrentCurrentWeatherRepoImpl(remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideGetCurrentWeatherUseCase(repository: CurrentWeatherRepo): GetCurrentWeatherUseCase {
        return GetCurrentWeatherUseCase(repository)
    }
}