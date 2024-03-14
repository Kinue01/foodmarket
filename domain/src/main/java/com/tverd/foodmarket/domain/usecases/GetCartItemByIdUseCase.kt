package com.tverd.foodmarket.domain.usecases

import com.tverd.foodmarket.domain.model.Cart
import com.tverd.foodmarket.domain.repository.CartRepository

class GetCartItemByIdUseCase(
    private val cartRepository: CartRepository
) {

    suspend fun execute(id: Int): Cart {
        return cartRepository.getCartById(id)
    }

}