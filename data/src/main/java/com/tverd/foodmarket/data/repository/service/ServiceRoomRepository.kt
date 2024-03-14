package com.tverd.foodmarket.data.repository.service

import com.tverd.foodmarket.domain.model.Service

interface ServiceRoomRepository {

    suspend fun getService(id: Int): Service

    suspend fun saveService(service: Service)

    suspend fun deleteServices()

}