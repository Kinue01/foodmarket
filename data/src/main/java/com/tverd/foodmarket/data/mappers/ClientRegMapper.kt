package com.tverd.foodmarket.data.mappers

import com.tverd.foodmarket.domain.model.Client
import com.tverd.foodmarket.domain.model.ClientRegistration

class ClientRegMapper : BaseMapper<Client, ClientRegistration> {
    override fun mapFromClient(type: Client): ClientRegistration {
        return ClientRegistration(
            type.clientFirstName,
            type.clientLastName,
            type.clientPassword,
            type.clientMiddleName,
            type.clientPhone,
            type.clientAddress,
            type.clientEmail
        )
    }

    override fun mapToClient(type: ClientRegistration): Client {
        return Client(
            0,
            type.client_email,
            type.client_password,
            type.client_firstname,
            type.client_lastname,
            type.client_middlename,
            type.client_phone,
            type.client_adress
        )
    }
}