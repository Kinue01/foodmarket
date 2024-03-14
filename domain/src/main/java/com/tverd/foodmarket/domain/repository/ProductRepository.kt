package com.tverd.foodmarket.domain.repository

import com.tverd.foodmarket.domain.model.Product

interface ProductRepository {

    suspend fun getProducts(): List<Product>

    suspend fun getProductById(id: Int): Product

    suspend fun deleteProducts()

}