package com.tverd.foodmarket.domain.usecases

import com.tverd.foodmarket.domain.model.Cart
import com.tverd.foodmarket.domain.repository.CartRepository

class GetCartItemsUseCase(
    private val cartRepository: CartRepository
) {

    suspend fun execute(): List<Cart> {
        return cartRepository.getCartItems()
    }

}