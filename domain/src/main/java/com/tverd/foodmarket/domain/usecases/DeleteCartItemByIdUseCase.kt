package com.tverd.foodmarket.domain.usecases

import com.tverd.foodmarket.domain.model.Cart
import com.tverd.foodmarket.domain.repository.CartRepository

class DeleteCartItemByIdUseCase(
    private val cartRepository: CartRepository
) {

    suspend fun execute(id: Int) {
        return cartRepository.deleteCartItemById(id)
    }

}