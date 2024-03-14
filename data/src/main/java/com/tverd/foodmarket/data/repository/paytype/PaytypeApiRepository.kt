package com.tverd.foodmarket.data.repository.paytype

import com.tverd.foodmarket.domain.model.Paytype

interface PaytypeApiRepository {

    suspend fun getTypes(): List<Paytype>

}