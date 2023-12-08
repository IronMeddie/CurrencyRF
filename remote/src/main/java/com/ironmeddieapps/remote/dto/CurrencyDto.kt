package com.ironmeddieapps.models

import com.ironmeddieapps.remote.dto.ValuteDto

data class CurrencyDto(
    val Date: String,
    val PreviousDate: String,
    val PreviousURL: String,
    val Timestamp: String,
    val Valute: ValuteDto
){
    fun toCurrency() = Currency(Date,PreviousDate,PreviousURL,Timestamp,Valute.toList())
}