package com.ironmeddieapps.database.datasource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ironmeddieapps.database.entity.FavoriteValute
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM FavoriteValute")
    fun getFavorites(): Flow<List<FavoriteValute>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(valute: FavoriteValute)

    @Delete
    suspend fun delete(valute:FavoriteValute)

//    @Update
//    suspend fun updateAvatar(valute:FavoriteValute)
}