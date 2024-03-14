package com.tverd.foodmarket.domain.repository

import com.tverd.foodmarket.domain.model.Paytype

interface PaytypeRepository {

    suspend fun getTypes(): List<Paytype>

}