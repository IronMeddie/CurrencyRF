package com.ironmeddieapps.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ironmeddieapps.models.CurencyItem

@Entity
data class FavoriteValute (
    val CharCode: String,
    @PrimaryKey(autoGenerate = false)
    val ID: String,
    val Name: String,
)

fun CurencyItem.toEntityFavorite() = FavoriteValute(this.CharCode, this.ID, this.Name)