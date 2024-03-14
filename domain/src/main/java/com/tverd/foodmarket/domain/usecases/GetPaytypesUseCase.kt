package com.tverd.foodmarket.domain.usecases

import com.tverd.foodmarket.domain.model.Paytype
import com.tverd.foodmarket.domain.repository.PaytypeRepository

class GetPaytypesUseCase(
    private val paytypeRepository: PaytypeRepository
) {

    suspend fun execute(): List<Paytype> {
        return paytypeRepository.getTypes()
    }

}