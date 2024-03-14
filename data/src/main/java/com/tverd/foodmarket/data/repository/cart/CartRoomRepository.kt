package com.tverd.foodmarket.data.repository.cart

import com.tverd.foodmarket.domain.model.Cart

interface CartRoomRepository {

    suspend fun getCartItems(): List<Cart>

    suspend fun saveToCart(cart: Cart)

    suspend fun deleteCartItems()

    suspend fun deleteCartItemById(id: Int)

    suspend fun getCartItemById(id: Int): Cart

}