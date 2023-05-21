package com.ironmeddieapps.data.repository.di

import com.ironmeddieapps.data.repository.CurrencyRepositoryImpl
import com.ironmeddieapps.remote.repository.CurrencyRepository
import com.ironmeddieapps.remote.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule{

        @Provides
    @Singleton
    fun provideProductsRepository(api: ApiService) : CurrencyRepository {
        return CurrencyRepositoryImpl(api)
    }
}