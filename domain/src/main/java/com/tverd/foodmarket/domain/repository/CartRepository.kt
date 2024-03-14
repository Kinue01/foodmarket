package com.tverd.foodmarket.domain.repository

import com.tverd.foodmarket.domain.model.Cart

interface CartRepository {

    suspend fun getCartItems(): List<Cart>

    suspend fun saveToCart(cart: Cart)

    suspend fun deleteCartItems()

    suspend fun deleteCartItemById(id: Int)

    suspend fun getCartById(id: Int): Cart

}