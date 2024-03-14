package com.tverd.foodmarket.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tverd.foodmarket.roomdb.model.CurrClientEntity

@Dao
interface CurrClientDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveClient(clientEntity: CurrClientEntity)

    @Query("select * from tb_currclient")
    suspend fun getClient(): CurrClientEntity

    @Query("delete from tb_currclient")
    suspend fun deleteClient()
}