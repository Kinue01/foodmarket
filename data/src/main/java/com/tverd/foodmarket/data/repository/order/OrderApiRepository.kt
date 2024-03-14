package com.tverd.foodmarket.data.repository.order

import com.tverd.foodmarket.domain.model.Order

interface OrderApiRepository {

    suspend fun addOrder(order: Order): Boolean

    suspend fun addOrderByClient(order: Order): Boolean

}