package com.ironmeddieapps.data.repository

import com.ironmeddieapps.remote.repository.BaseRepository
import com.ironmeddieapps.remote.repository.CurrencyRepository
import com.ironmeddieapps.remote.service.ApiService
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(private val  service: ApiService) : BaseRepository, CurrencyRepository{

    override fun getCurrency() = safeApiCall { service.getCurrency().toCurrency() }
}