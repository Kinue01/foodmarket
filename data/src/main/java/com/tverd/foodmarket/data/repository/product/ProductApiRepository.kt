package com.tverd.foodmarket.data.repository.product

import com.tverd.foodmarket.domain.model.Product

interface ProductApiRepository {

    suspend fun getProducts(): List<Product>
    suspend fun getProductById(id: Int): Product

}