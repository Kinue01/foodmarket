package com.tverd.foodmarket.domain.repository

import com.tverd.foodmarket.domain.model.Order

interface OrderRepository {

    suspend fun addOrder(order: Order): Boolean

}