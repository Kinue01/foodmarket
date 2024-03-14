package com.tverd.foodmarket.data.repository.service

import com.tverd.foodmarket.domain.model.Service

interface ServiceApiRepository {

    suspend fun getService(id: Int): Service

}