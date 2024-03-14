package com.tverd.foodmarket.data.repositoryimplementations

import com.tverd.foodmarket.data.repository.cart.CartRoomRepository
import com.tverd.foodmarket.domain.model.Cart
import com.tverd.foodmarket.domain.repository.CartRepository

class CartRepositoryImpl(
    private val cartRoomRepository: CartRoomRepository
) : CartRepository {
    override suspend fun getCartItems(): List<Cart> {
        return cartRoomRepository.getCartItems()
    }

    override suspend fun saveToCart(cart: Cart) {
        cartRoomRepository.saveToCart(cart)
    }

    override suspend fun deleteCartItems() {
        cartRoomRepository.deleteCartItems()
    }

    override suspend fun deleteCartItemById(id: Int) {
        cartRoomRepository.deleteCartItemById(id)
    }

    override suspend fun getCartById(id: Int): Cart {
        return cartRoomRepository.getCartItemById(id)
    }
}