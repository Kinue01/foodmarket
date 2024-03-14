package com.tverd.foodmarket.domain.usecases

import com.tverd.foodmarket.domain.model.Client
import com.tverd.foodmarket.domain.repository.ClientRepository

class GetLastClientUseCase(
    private val clientRepository: ClientRepository
) {

     suspend fun execute(): Client {
         return clientRepository.getClientFromRoom()
     }

}