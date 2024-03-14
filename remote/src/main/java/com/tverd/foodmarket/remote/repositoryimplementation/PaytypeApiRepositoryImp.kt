package com.tverd.foodmarket.remote.repositoryimplementation

import com.tverd.foodmarket.data.repository.paytype.PaytypeApiRepository
import com.tverd.foodmarket.domain.model.Paytype
import com.tverd.foodmarket.remote.api.ApiService
import com.tverd.foodmarket.remote.mappers.PaytypeApiMapper

class PaytypeApiRepositoryImp(
    private val apiService: ApiService,
    private val paytypeApiMapper: PaytypeApiMapper
) : PaytypeApiRepository {

    override suspend fun getTypes(): List<Paytype> {
        val res = apiService.getPayTypes()

        return if (res.code() == 200) {
            res.body()!!.map {
                paytypeApiMapper.mapFromModel(it)
            }
        }
        else {
            listOf()
        }
    }
}
