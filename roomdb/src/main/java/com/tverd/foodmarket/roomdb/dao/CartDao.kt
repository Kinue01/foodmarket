package com.tverd.foodmarket.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tverd.foodmarket.roomdb.model.CartEntity

@Dao
interface CartDao {

    @Query("select * from tb_cart")
    suspend fun getCartItems(): List<CartEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveToCart(cart: CartEntity)

    @Query("delete from tb_cart")
    suspend fun deleteCartItems()

    @Query("delete from tb_cart where prodId = :id")
    suspend fun deleteCartItemById(id: Int)

    @Query("select * from tb_cart where prodId = :id")
    suspend fun getCartItemById(id: Int): CartEntity

}