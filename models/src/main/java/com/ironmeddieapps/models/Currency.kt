package com.ironmeddieapps.models

data class Currency(
    val Date: String,
    val PreviousDate: String,
    val PreviousURL: String,
    val Timestamp: String,
    val Valute: List<CurencyItem>
)