package com.tverd.foodmarket.remote.repositoryimplementation

import com.tverd.foodmarket.data.repository.client.ClientApiRepository
import com.tverd.foodmarket.domain.model.Client
import com.tverd.foodmarket.domain.model.ClientLogin
import com.tverd.foodmarket.domain.model.ClientRegistration
import com.tverd.foodmarket.remote.api.ApiService
import com.tverd.foodmarket.remote.mappers.ClientApiMapper
import com.tverd.foodmarket.remote.model.ClientApi

class ClientApiRepositoryImpl(
    private val apiService: ApiService,
    private val clientApiMapper: ClientApiMapper
) : ClientApiRepository {

    override suspend fun addClient(data: ClientRegistration): Boolean {
        val res = apiService.addClient(data)

        return if (res.code() == 201) {
            true
        } else {
            false
        }
    }

    override suspend fun getClientEmailPass(data: ClientLogin): Client {
        val res = apiService.getClientEmailPass(data)

        return if (res.isSuccessful) {
            clientApiMapper.mapFromModel(res.body()!!)
        } else {
            clientApiMapper.mapFromModel(ClientApi())
        }
    }

}