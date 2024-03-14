package com.tverd.foodmarket.remote.mappers

import com.tverd.foodmarket.domain.model.Client
import com.tverd.foodmarket.remote.model.ClientApi

class ClientApiMapper : EntityMapper<ClientApi, Client> {
    override suspend fun mapFromModel(model: ClientApi): Client {
        return Client(
            model.clientId,
            model.clientEmail,
            model.clientPassword,
            model.clientFirstname,
            model.clientLastname,
            model.clientMiddlename,
            model.clientPhone,
            model.clientAdress
        )
    }
}