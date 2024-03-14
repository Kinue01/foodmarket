package com.tverd.foodmarket.remote.repositoryimplementation

import com.tverd.foodmarket.data.repository.order.OrderApiRepository
import com.tverd.foodmarket.domain.model.Order
import com.tverd.foodmarket.remote.api.ApiService
import com.tverd.foodmarket.remote.mappers.OrderApiMapper
import com.tverd.foodmarket.remote.mappers.OrderByClientApiMapper

class OrderApiRepositoryImpl(
    private val apiService: ApiService,
    private val orderApiMapper: OrderApiMapper,
    private val orderByClientApiMapper: OrderByClientApiMapper
) : OrderApiRepository {

    override suspend fun addOrder(order: Order): Boolean {
        val res = apiService.addOrder(orderApiMapper.mapFromModel(order))

        return res.code() == 201
    }

    override suspend fun addOrderByClient(order: Order): Boolean {
        val res = apiService.addOrderByClient(orderByClientApiMapper.mapFromModel(order))

        return res.code() == 201
    }
}