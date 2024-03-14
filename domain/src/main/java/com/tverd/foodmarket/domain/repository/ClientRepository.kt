package com.tverd.foodmarket.domain.repository

import com.tverd.foodmarket.domain.model.Client
import com.tverd.foodmarket.domain.model.ClientLogin
import com.tverd.foodmarket.domain.model.ClientRegistration
import kotlinx.coroutines.flow.Flow

interface ClientRepository {

    suspend fun addClient(data: ClientRegistration): Boolean

    suspend fun checkClient(): Boolean

    suspend fun getClient(data: ClientLogin): Client

    suspend fun deleteClient(): Boolean

    suspend fun getClientFromRoom(): Client

}