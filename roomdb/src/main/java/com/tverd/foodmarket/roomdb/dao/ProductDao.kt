package com.tverd.foodmarket.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tverd.foodmarket.roomdb.model.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("select * from tb_product")
    suspend fun getProducts(): List<ProductEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProducts(products: List<ProductEntity>)

    @Query("delete from tb_product")
    suspend fun deleteProducts()

    @Query("select * from tb_product where prodId = :id")
    suspend fun getProductById(id: Int): ProductEntity

}