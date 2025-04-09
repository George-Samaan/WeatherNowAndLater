package com.vodafonetask.data.di

import android.content.Context
import android.content.SharedPreferences
import com.vodafonetask.data.local.CityLocalDataSource
import com.vodafonetask.data.local.CityLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    @Singleton
    fun provideCityLocalDataSource(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("city_prefs", Context.MODE_PRIVATE)
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class CityLocalDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindCityLocalDataSource(
        impl: CityLocalDataSourceImpl
    ): CityLocalDataSource
}