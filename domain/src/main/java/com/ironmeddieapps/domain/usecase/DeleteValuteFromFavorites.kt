package com.ironmeddieapps.domain.usecase

import com.ironmeddieapps.database.repository.FavoriteRepository
import com.ironmeddieapps.models.CurencyItem
import javax.inject.Inject

class DeleteValuteFromFavorites @Inject constructor(private val favoriteRep: FavoriteRepository){

    suspend operator fun invoke(valute: CurencyItem) =  favoriteRep.delete(valute)
}