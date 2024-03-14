package com.tverd.foodmarket.remote.mappers

import com.tverd.foodmarket.data.repository.client.ClientRoomRepository
import com.tverd.foodmarket.domain.model.Order
import com.tverd.foodmarket.remote.model.OrderByClientApi

class OrderByClientApiMapper(
    private val clientRoomRepository: ClientRoomRepository
) : EntityMapper<Order, OrderByClientApi> {
    override suspend fun mapFromModel(model: Order): OrderByClientApi {
        return OrderByClientApi(
            clientRoomRepository.getLastClient().clientId,
            model.orderPaytypeId,
            model.orderProdId,
            model.orderProdCount
        )
    }
}