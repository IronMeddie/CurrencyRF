package com.ironmeddieapps.database.repository

import com.ironmeddieapps.database.datasource.FavoriteDao
import com.ironmeddieapps.database.entity.toEntityFavorite
import com.ironmeddieapps.models.CurencyItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(private val dao: FavoriteDao):
    FavoriteRepository {

    override fun getFavorite(): Flow<List<String>> = dao.getFavorites().map { it.map { it.CharCode } }


    override suspend fun save(valute: CurencyItem) = dao.insert(valute.toEntityFavorite())

    override suspend fun delete(valute: CurencyItem)= dao.delete(valute.toEntityFavorite())
}