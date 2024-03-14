package com.tverd.foodmarket.domain.usecases

import com.tverd.foodmarket.domain.model.ClientRegistration
import com.tverd.foodmarket.domain.repository.ClientRepository
import kotlinx.coroutines.flow.single

class AddClientUseCase(
    private val clientRepository: ClientRepository
) {

    suspend fun execute(data: ClientRegistration): Boolean {
        return clientRepository.addClient(data)
    }

}