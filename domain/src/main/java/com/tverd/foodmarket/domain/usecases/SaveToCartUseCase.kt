package com.tverd.foodmarket.domain.usecases

import com.tverd.foodmarket.domain.model.Cart
import com.tverd.foodmarket.domain.repository.CartRepository

class SaveToCartUseCase(
    private val cartRepository: CartRepository
) {

    suspend fun execute(cart: Cart) {
        cartRepository.saveToCart(cart)
    }

}