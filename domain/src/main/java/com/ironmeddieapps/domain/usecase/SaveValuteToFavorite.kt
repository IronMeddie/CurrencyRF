package com.ironmeddieapps.domain.usecase

import com.ironmeddieapps.database.repository.FavoriteRepository
import com.ironmeddieapps.models.CurencyItem
import javax.inject.Inject

class SaveValuteToFavorite @Inject constructor(private val favoriteRep: FavoriteRepository){

    suspend operator fun invoke(valute: CurencyItem) =  favoriteRep.save(valute)
}