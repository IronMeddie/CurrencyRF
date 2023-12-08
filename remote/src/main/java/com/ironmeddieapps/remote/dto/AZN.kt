package com.ironmeddieapps.remote.dto

import com.ironmeddieapps.models.CurencyItem

data class AZN(
    val CharCode: String,
    val ID: String,
    val Name: String,
    val Nominal: Int,
    val NumCode: String,
    val Previous: Double,
    val Value: Double
){
    fun toItem(): CurencyItem {
        return CurencyItem(CharCode, ID,Name, Nominal, NumCode, Previous, Value)
    }
}