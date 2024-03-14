package com.tverd.foodmarket.data.repositoryimplementations

import com.tverd.foodmarket.data.repository.product.ProductApiRepository
import com.tverd.foodmarket.data.repository.product.ProductRoomRepository
import com.tverd.foodmarket.domain.model.Product
import com.tverd.foodmarket.domain.repository.ProductRepository

class ProductRepositoryImpl(
    private val productApiRepository: ProductApiRepository,
    private val productRoomRepository: ProductRoomRepository
) : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        return if (productRoomRepository.isCached())
            productRoomRepository.getProducts()
        else {
            val res = productApiRepository.getProducts()
            productRoomRepository.saveProducts(res)
            res
        }
    }

    override suspend fun getProductById(id: Int): Product {
        val res = productRoomRepository.getProductById(id)
        return if (res.prod_id == 0)
            productApiRepository.getProductById(id)
        else
            res
    }

    override suspend fun deleteProducts() {
        productRoomRepository.deleteProducts()
    }

}