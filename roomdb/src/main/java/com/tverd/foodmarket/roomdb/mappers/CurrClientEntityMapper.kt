package com.tverd.foodmarket.roomdb.mappers

import com.tverd.foodmarket.domain.model.Client
import com.tverd.foodmarket.roomdb.model.CurrClientEntity

class CurrClientEntityMapper : RoomMapper<CurrClientEntity, Client> {
    override suspend fun mapFromEntity(type: CurrClientEntity): Client {
        return Client(
            type.clientId,
            type.clientEmail,
            type.clientPassword,
            type.clientFirstName,
            type.clientLastName,
            type.clientMiddleName,
            type.clientPhone,
            type.clientAddress
        )
    }

    override fun mapToEntity(type: Client): CurrClientEntity {
        return CurrClientEntity(
            type.clientId,
            type.clientFirstName,
            type.clientLastName,
            type.clientMiddleName,
            type.clientEmail,
            type.clientPassword,
            type.clientPhone,
            type.clientAddress
        )
    }
}