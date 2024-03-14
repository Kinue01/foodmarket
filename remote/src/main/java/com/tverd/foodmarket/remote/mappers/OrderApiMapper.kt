package com.tverd.foodmarket.remote.mappers

import com.tverd.foodmarket.domain.model.Order
import com.tverd.foodmarket.remote.model.OrderApi

class OrderApiMapper : EntityMapper<Order, OrderApi> {
    override suspend fun mapFromModel(model: Order): OrderApi {
        return OrderApi(
            model.orderClientFirstname,
            model.orderClientLastname,
            model.orderClientMiddletname,
            model.orderClientPhone,
            model.orderClientAddress,
            model.orderPaytypeId,
            model.orderProdId,
            model.orderProdCount
        )
    }
}