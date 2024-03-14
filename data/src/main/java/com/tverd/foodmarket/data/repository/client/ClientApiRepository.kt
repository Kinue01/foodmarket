package com.tverd.foodmarket.data.repository.client

import com.tverd.foodmarket.domain.model.Client
import com.tverd.foodmarket.domain.model.ClientLogin
import com.tverd.foodmarket.domain.model.ClientRegistration

interface ClientApiRepository {

    suspend fun addClient(data: ClientRegistration): Boolean

    suspend fun getClientEmailPass(data: ClientLogin): Client

}