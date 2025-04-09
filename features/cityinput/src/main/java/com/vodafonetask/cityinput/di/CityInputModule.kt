package com.vodafonetask.cityinput.di

import com.vodafonetask.cityinput.data.repo.CityInputRepositoryImpl
import com.vodafonetask.cityinput.domain.repo.CityInputRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CityInputModule {

    @Binds
    @Singleton
    abstract fun bindCityInputRepository(
        impl: CityInputRepositoryImpl
    ): CityInputRepository
}