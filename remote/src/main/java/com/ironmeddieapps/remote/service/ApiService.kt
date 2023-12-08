package com.ironmeddieapps.remote.service

import com.ironmeddieapps.models.CurrencyDto
import com.ironmeddieapps.remote.utils.Constance
import retrofit2.http.GET

interface ApiService {

    @GET(Constance.CURRENCY_JSON)
    suspend fun getCurrency(): CurrencyDto

    @GET(Constance.CURRENCY_JSON)
    suspend fun getCurrencyString(): String


}