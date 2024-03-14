package com.tverd.foodmarket.remote.repositoryimplementation

import com.tverd.foodmarket.data.repository.product.ProductApiRepository
import com.tverd.foodmarket.domain.model.Product
import com.tverd.foodmarket.remote.api.ApiService
import com.tverd.foodmarket.remote.mappers.ProductApiMapper
import com.tverd.foodmarket.remote.model.ProductApi

class ProductApiRepositoryImpl(
    private val apiService: ApiService,
    private val productApiMapper: ProductApiMapper
) : ProductApiRepository {

    override suspend fun getProducts(): List<Product> {

        val res = apiService.getProducts()

        return if (res.code() == 200) {
            res.body()!!.map { item ->
                productApiMapper.mapFromModel(item)
            }
        } else {
            listOf(ProductApi()).map { item ->
                productApiMapper.mapFromModel(item)
            }
        }
    }

    override suspend fun getProductById(id: Int): Product {
        val res = apiService.getProdById(id)

        return if (res.code() == 200) {
            productApiMapper.mapFromModel(res.body()!!)
        } else {
            productApiMapper.mapFromModel(ProductApi())
        }
    }
}