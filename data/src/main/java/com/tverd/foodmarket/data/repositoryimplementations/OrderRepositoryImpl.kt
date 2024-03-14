package com.tverd.foodmarket.data.repositoryimplementations

import com.tverd.foodmarket.data.repository.client.ClientRoomRepository
import com.tverd.foodmarket.data.repository.order.OrderApiRepository
import com.tverd.foodmarket.domain.model.Order
import com.tverd.foodmarket.domain.repository.OrderRepository

class OrderRepositoryImpl(
    private val orderApiRepository: OrderApiRepository,
    private val clientRoomRepository: ClientRoomRepository
) : OrderRepository {

    override suspend fun addOrder(order: Order): Boolean {
        return if (clientRoomRepository.isCached())
            orderApiRepository.addOrderByClient(order)
        else
            orderApiRepository.addOrder(order)
    }

}