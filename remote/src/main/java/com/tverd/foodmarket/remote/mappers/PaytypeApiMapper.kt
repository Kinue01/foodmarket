package com.tverd.foodmarket.remote.mappers

import com.tverd.foodmarket.domain.model.Paytype
import com.tverd.foodmarket.remote.model.PayTypeApi

class PaytypeApiMapper : EntityMapper<PayTypeApi, Paytype> {
    override suspend fun mapFromModel(model: PayTypeApi): Paytype {
        return Paytype(
            model.type_id,
            model.type_name
        )
    }
}