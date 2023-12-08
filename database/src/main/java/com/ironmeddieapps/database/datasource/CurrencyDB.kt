package com.ironmeddieapps.database.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ironmeddieapps.database.entity.FavoriteValute

@Database(entities = [FavoriteValute::class], version = 1)
abstract class CurrencyDB: RoomDatabase() {

    abstract val valuteDao: FavoriteDao

    companion object{
        const val DATABASE_NAME = "currency"
    }
}