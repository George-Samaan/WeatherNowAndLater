package com.vodafonetask.weathernowandlater.di

import com.vodafonetask.weathernowandlater.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Named("weather_api_key")
    fun provideApiKey(): String = BuildConfig.OPEN_WEATHER_API_KEY
}