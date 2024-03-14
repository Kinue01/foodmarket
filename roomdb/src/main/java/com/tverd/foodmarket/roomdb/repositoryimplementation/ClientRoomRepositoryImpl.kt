package com.tverd.foodmarket.roomdb.repositoryimplementation

import com.tverd.foodmarket.data.mappers.ClientRegMapper
import com.tverd.foodmarket.data.repository.client.ClientRoomRepository
import com.tverd.foodmarket.domain.model.Client
import com.tverd.foodmarket.domain.model.ClientLogin
import com.tverd.foodmarket.domain.model.ClientRegistration
import com.tverd.foodmarket.roomdb.dao.ClientDao
import com.tverd.foodmarket.roomdb.dao.CurrClientDao
import com.tverd.foodmarket.roomdb.mappers.ClientEntityMapper
import com.tverd.foodmarket.roomdb.mappers.CurrClientEntityMapper

class ClientRoomRepositoryImpl(
    private val clientDao: ClientDao,
    private val clientEntityMapper: ClientEntityMapper,
    private val currClientDao: CurrClientDao,
    private val currClientEntityMapper: CurrClientEntityMapper
) : ClientRoomRepository {

    override suspend fun getLastClient(): Client {
        val res = currClientDao.getClient()
        return if (res != null) {
            currClientEntityMapper.mapFromEntity(res)
        }
        else {
            Client()
        }
    }

    override suspend fun saveClient(client: Client): Boolean {
        clientDao.saveClient(clientEntityMapper.mapToEntity(client))
        currClientDao.deleteClient()
        currClientDao.saveClient(currClientEntityMapper.mapToEntity(client))
        return if (currClientDao.getClient().clientId == client.clientId) {
            true
        } else {
            false
        }
    }

    override suspend fun isCached(): Boolean {
        return currClientDao.getClient() != null
    }

    override suspend fun deleteClient(): Boolean {
        currClientDao.deleteClient()

        return !isCached()
    }

    override suspend fun getClientEmailPass(data: ClientLogin): Client {
        val res = clientDao.getClient(data.email, data.password)

        return if (res != null) {
            currClientDao.saveClient(currClientEntityMapper.mapToEntity(clientEntityMapper.mapFromEntity(res)))
            clientEntityMapper.mapFromEntity(res)
        }
        else
            Client()
    }
}