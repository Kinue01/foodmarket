package com.tverd.foodmarket.remote.mappers

import com.tverd.foodmarket.domain.model.Product
import com.tverd.foodmarket.remote.api.ApiService
import com.tverd.foodmarket.remote.model.ProductApi

class ProductApiMapper(
    private val serviceApiMapper: ServiceApiMapper,
    private val apiService: ApiService
) : EntityMapper<ProductApi, Product> {

    override suspend fun mapFromModel(model: ProductApi): Product {
        return Product(
            prod_id = model.prodId,
            prod_title = model.prodTitle,
            prod_description = model.prodDescription,
            prod_price = model.prodPrice,
            prod_image = model.prodImage,
            prod_weight = model.prodWeight,
            prod_service = serviceApiMapper.mapFromModel(apiService.getService(model.prodService).body()!!)
        )
    }

}