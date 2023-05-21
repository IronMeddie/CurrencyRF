package com.ironmeddieapps.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ironmeddieapps.models.CurencyItem

@Entity
data class CurrencyItemHistory (
val CharCode: String,
@PrimaryKey(autoGenerate = false)
val ID: String,
val Name: String,
val Nominal: Int,
val NumCode: String,
val Previous: Double,
val Value: Double
){
    fun toCurrencyItem(): CurencyItem {
        return CurencyItem(
            this.CharCode, this.ID, this.Name, this.Nominal, this.NumCode, this.Previous, this.Value
        )
    }
}

fun CurencyItem.toEntity() : CurrencyItemHistory{
    return CurrencyItemHistory(
        this.CharCode, this.ID, this.Name, this.Nominal, this.NumCode, this.Previous, this.Value
    )
}

