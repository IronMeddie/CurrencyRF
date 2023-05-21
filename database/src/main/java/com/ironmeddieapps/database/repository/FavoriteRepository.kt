package com.ironmeddieapps.database.repository

import com.ironmeddieapps.models.CurencyItem
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {

    fun getFavorite(): Flow<List<String>>

    suspend fun save(valute: CurencyItem)
    suspend fun delete(valute: CurencyItem)
}