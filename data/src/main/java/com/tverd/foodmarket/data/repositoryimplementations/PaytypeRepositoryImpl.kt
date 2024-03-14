package com.tverd.foodmarket.data.repositoryimplementations

import com.tverd.foodmarket.data.repository.paytype.PaytypeApiRepository
import com.tverd.foodmarket.domain.model.Paytype
import com.tverd.foodmarket.domain.repository.PaytypeRepository

class PaytypeRepositoryImpl(
    private val paytypeApiRepository: PaytypeApiRepository
) : PaytypeRepository {
    override suspend fun getTypes(): List<Paytype> {
        return paytypeApiRepository.getTypes()
    }
}