package com.ironmeddieapps.domain.usecase

import com.ironmeddieapps.database.repository.FavoriteRepository
import com.ironmeddieapps.remote.repository.CurrencyRepository
import com.ironmeddieapps.utils.DataResource
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetFavoriteValutes @Inject constructor(private val savedRep: FavoriteRepository, private val currencyRep: CurrencyRepository){

    operator fun invoke() = savedRep.getFavorite().combine(currencyRep.getCurrency()){ favorites, data->
        when (data ){
            is DataResource.Success -> {
                val valute = data.data.Valute.filter { favorites.contains(it.CharCode) }

                 DataResource.Success(data.data.copy(Valute = valute))}
            else -> data
        }
    }


}