package com.tverd.foodmarket.data.repositoryimplementations

import com.tverd.foodmarket.data.mappers.ClientRegMapper
import com.tverd.foodmarket.data.repository.client.ClientApiRepository
import com.tverd.foodmarket.data.repository.client.ClientRoomRepository
import com.tverd.foodmarket.domain.model.Client
import com.tverd.foodmarket.domain.model.ClientLogin
import com.tverd.foodmarket.domain.model.ClientRegistration
import com.tverd.foodmarket.domain.repository.ClientRepository

class ClientRepositoryImpl(
    private val clientRoomRepository: ClientRoomRepository,
    private val clientApiRepository: ClientApiRepository,
) : ClientRepository {

    override suspend fun addClient(data: ClientRegistration): Boolean {
        return if (clientApiRepository.addClient(data)) {
            true
        } else
            false
    }

    override suspend fun checkClient(): Boolean {
        return clientRoomRepository.isCached()
    }

    override suspend fun getClient(data: ClientLogin): Client {
        val res = clientRoomRepository.getClientEmailPass(data)
        return if (res.clientId != 0)
            res
        else {
            val api = clientApiRepository.getClientEmailPass(data)
            clientRoomRepository.saveClient(api)
            api
        }


    }

    override suspend fun deleteClient(): Boolean {
        return clientRoomRepository.deleteClient()
    }

    override suspend fun getClientFromRoom(): Client {
        return clientRoomRepository.getLastClient()
    }

}