package com.ironmeddieapps.domain.usecase

import com.ironmeddieapps.database.repository.FavoriteRepository
import com.ironmeddieapps.remote.repository.CurrencyRepository
import com.ironmeddieapps.utils.DataResource
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCurrency @Inject constructor(private val repositori: CurrencyRepository, private val savedRep: FavoriteRepository) {

    operator fun invoke() = savedRep.getFavorite().combine(repositori.getCurrency()){ favorites, data->
        when (data ){
            is DataResource.Success -> {
                val valute = data.data.Valute.filter { !favorites.contains(it.CharCode) }

                DataResource.Success(data.data.copy(Valute = valute))}
            else -> data
        }
    }

}