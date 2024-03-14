package com.tverd.foodmarket.domain.usecases

import com.tverd.foodmarket.domain.repository.ClientRepository

class DeleteClientUseCase(
    private val clientRepository: ClientRepository
) {

    suspend fun execute(): Boolean {
        return clientRepository.deleteClient()
    }

}