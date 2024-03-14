package com.tverd.foodmarket.data.repository.client

import com.tverd.foodmarket.domain.model.Client
import com.tverd.foodmarket.domain.model.ClientLogin
import com.tverd.foodmarket.domain.model.ClientRegistration

interface ClientRoomRepository {

    suspend fun getLastClient(): Client

    suspend fun saveClient(client: Client): Boolean

    suspend fun isCached(): Boolean

    suspend fun deleteClient(): Boolean

    suspend fun getClientEmailPass(data: ClientLogin): Client

}