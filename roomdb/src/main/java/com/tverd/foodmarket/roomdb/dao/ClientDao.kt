package com.tverd.foodmarket.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tverd.foodmarket.domain.model.ClientLogin
import com.tverd.foodmarket.roomdb.model.ClientEntity
import com.tverd.foodmarket.roomdb.model.CurrClientEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ClientDao {

    @Query("select * from tb_client order by clientId desc")
    suspend fun getClients(): List<ClientEntity>

    @Query("select * from tb_client where client_email = :email and client_password = :pass")
    suspend fun getClient(email: String, pass: String): ClientEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveClient(clientEntity: ClientEntity)

    @Query("select * from tb_currclient order by clientId desc limit 1")
    suspend fun getClient(): ClientEntity

    @Query("delete from tb_client")
    suspend fun deleteClients()

}