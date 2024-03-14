package com.tverd.foodmarket.roomdb.mappers

import com.tverd.foodmarket.data.repository.product.ProductRoomRepository
import com.tverd.foodmarket.domain.model.Cart
import com.tverd.foodmarket.roomdb.model.CartEntity

class CartEntityMapper(
    private val productRoomRepository: ProductRoomRepository
) : RoomMapper<CartEntity, Cart> {
    override suspend fun mapFromEntity(type: CartEntity): Cart {

        val prod = productRoomRepository.getProductById(type.prodId)

        return Cart(
            type.prodId,
            prod.prod_title,
            prod.prod_description,
            prod.prod_price,
            prod.prod_weight,
            prod.prod_image,
            prod.prod_service,
            type.prodCount
        )
    }

    override fun mapToEntity(type: Cart): CartEntity {
        return CartEntity(
            type.prodId,
            type.prodCount
        )
    }
}