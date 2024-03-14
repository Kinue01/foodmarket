package com.tverd.foodmarket.remote.model

import com.google.gson.annotations.SerializedName

class OrderByClientApi(
    @SerializedName("order_client_id")
    val order_client_id: Int = 0,
    @SerializedName("order_paytype_id")
    val order_paytype_id: Int = 0,
    @SerializedName("order_prod_id")
    val order_prod_id: Int = 0,
    @SerializedName("order_prod_count")
    val order_prod_count: Int = 0
)