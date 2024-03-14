package com.tverd.foodmarket.domain.usecases

import com.tverd.foodmarket.domain.model.Product
import com.tverd.foodmarket.domain.repository.ProductRepository

class GetProductsUseCase(
    private val productRepository: ProductRepository
) {

    suspend fun execute(): List<Product> {
        return productRepository.getProducts()
    }

}