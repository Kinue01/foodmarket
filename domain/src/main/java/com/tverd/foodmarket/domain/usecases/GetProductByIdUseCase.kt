package com.tverd.foodmarket.domain.usecases

import com.tverd.foodmarket.domain.model.Product
import com.tverd.foodmarket.domain.repository.ProductRepository

class GetProductByIdUseCase(private val productRepository: ProductRepository) {

    suspend fun execute(id: Int): Product {
        return productRepository.getProductById(id)
    }

}