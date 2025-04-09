package com.vodafonetask.data.di

import com.vodafonetask.data.BuildConfig
import com.vodafonetask.data.remote.WeatherRemoteDataSource
import com.vodafonetask.data.remote.WeatherRemoteDataSourceImpl
import com.vodafonetask.data.remote.api.WeatherApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    @Provides
    @Named("weather_api_key")
    fun provideApiKey(): String = BuildConfig.OPEN_WEATHER_API_KEY

    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRemoteDataSource(
        api: WeatherApiService,
        @Named("weather_api_key") apiKey: String
    ): WeatherRemoteDataSource {
        return WeatherRemoteDataSourceImpl(api, apiKey)
    }

}