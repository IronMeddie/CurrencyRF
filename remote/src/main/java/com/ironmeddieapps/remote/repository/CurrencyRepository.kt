package com.ironmeddieapps.remote.repository

import com.ironmeddieapps.models.Currency
import com.ironmeddieapps.models.CurrencyDto
import com.ironmeddieapps.utils.DataResource
import kotlinx.coroutines.flow.Flow

interface CurrencyRepository{

    fun  getCurrency(): Flow<DataResource<Currency>>
}