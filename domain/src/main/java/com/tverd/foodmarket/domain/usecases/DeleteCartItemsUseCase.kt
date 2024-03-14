package com.tverd.foodmarket.domain.usecases

import com.tverd.foodmarket.domain.repository.CartRepository

class DeleteCartItemsUseCase(
    private val cartRepository: CartRepository
) {

    suspend fun execute() {
        cartRepository.deleteCartItems()
    }

}