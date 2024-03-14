package com.tverd.foodmarket.domain.usecases

import com.tverd.foodmarket.domain.model.Client
import com.tverd.foodmarket.domain.model.ClientLogin
import com.tverd.foodmarket.domain.repository.ClientRepository
import kotlinx.coroutines.flow.single

class GetClientByEmailAndPassUseCase(
    private val clientRepository: ClientRepository
) {

    suspend fun execute(data: ClientLogin): Client {
        return clientRepository.getClient(data)
    }

}