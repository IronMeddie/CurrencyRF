package com.ironmeddieapps.database.di

import android.app.Application
import androidx.room.Room
import com.ironmeddieapps.database.datasource.CurrencyDB
import com.ironmeddieapps.database.repository.FavoriteRepository
import com.ironmeddieapps.database.repository.FavoriteRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideDatabase(app: Application): CurrencyDB = Room.databaseBuilder(
        app,
        CurrencyDB::class.java, CurrencyDB.DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideNoteRepository(db: CurrencyDB): FavoriteRepository = FavoriteRepositoryImpl(db.valuteDao)
}