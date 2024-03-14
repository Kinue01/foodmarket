package com.tverd.foodmarket.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tverd.foodmarket.roomdb.model.ServiceEntity

@Dao
interface ServiceDao {

    @Query("select * from tb_service where serviceId = :id")
    suspend fun getService(id: Int): ServiceEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveService(serviceEntity: ServiceEntity)

    @Query("delete from tb_service")
    suspend fun deleteServices()

}