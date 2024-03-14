package com.tverd.foodmarket.domain.usecases

import com.tverd.foodmarket.domain.model.Order
import com.tverd.foodmarket.domain.repository.OrderRepository

class AddOrderUseCase(
    private val orderRepository: OrderRepository
) {

    suspend fun execute(order: Order): Boolean {
        return orderRepository.addOrder(order)
    }

}