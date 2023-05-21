package com.ironmeddieapps.remote.service

import com.ironmeddieapps.models.Currency
import com.ironmeddieapps.remote.utils.Constance
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ApiService {

    @GET(Constance.CURRENCY_JSON)
    fun getCurrency(): Flow<Currency>

}