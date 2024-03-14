package com.tverd.foodmarket.domain.usecases

import com.tverd.foodmarket.domain.repository.ProductRepository

class DeleteRoomProductsUseCase(
    private val productRepository: ProductRepository
) {

    suspend fun execute() {
        productRepository.deleteProducts()
    }

}