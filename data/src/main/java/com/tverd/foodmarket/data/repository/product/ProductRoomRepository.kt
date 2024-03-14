package com.tverd.foodmarket.data.repository.product

import com.tverd.foodmarket.domain.model.Product

interface ProductRoomRepository {

    suspend fun getProducts(): List<Product>

    suspend fun saveProducts(products: List<Product>)

    suspend fun deleteProducts()

    suspend fun isCached(): Boolean

    suspend fun getProductById(id: Int): Product

}