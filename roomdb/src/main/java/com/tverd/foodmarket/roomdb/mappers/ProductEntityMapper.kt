package com.tverd.foodmarket.roomdb.mappers

import com.tverd.foodmarket.domain.model.Product
import com.tverd.foodmarket.remote.api.ApiService
import com.tverd.foodmarket.remote.mappers.ServiceApiMapper
import com.tverd.foodmarket.roomdb.dao.ServiceDao
import com.tverd.foodmarket.roomdb.model.ProductEntity

class ProductEntityMapper(
    private val serviceDao: ServiceDao,
    private val serviceEntityMapper: ServiceEntityMapper
) : RoomMapper<ProductEntity, Product> {
    override suspend fun mapFromEntity(type: ProductEntity): Product {
        return Product(
            type.prodId,
            type.prodTitle,
            type.prodDescription,
            type.prodPrice,
            type.prodWeight,
            type.prodImage,
            serviceEntityMapper.mapFromEntity(serviceDao.getService(type.prodServiceId))
        )
    }

    override fun mapToEntity(type: Product): ProductEntity {
        return ProductEntity(
            type.prod_id,
            type.prod_title,
            type.prod_description,
            type.prod_price,
            type.prod_weight,
            type.prod_service.service_name.substringBefore(" ").lowercase() + "_" + type.prod_title.trim().replace(" ", "").lowercase() + ".png",
            type.prod_service.service_id
        )
    }

}