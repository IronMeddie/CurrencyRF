package com.ironmeddieapps.domain.usecase

import com.ironmeddieapps.remote.repository.CurrencyRepository
import javax.inject.Inject

class GetCurrency @Inject constructor(private val repositori: CurrencyRepository) {

    operator fun invoke() = repositori.getCurrency()

}