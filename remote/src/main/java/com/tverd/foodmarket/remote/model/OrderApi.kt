package com.tverd.foodmarket.remote.model

import com.google.gson.annotations.SerializedName

class OrderApi(
    @SerializedName("order_client_firstname")
    val order_client_firstname: String = "",
    @SerializedName("order_client_lastname")
    val order_client_lastname: String = "",
    @SerializedName("order_client_middlename")
    val order_client_middlename: String = "",
    @SerializedName("order_client_phone")
    val order_client_phone: String = "",
    @SerializedName("order_client_adress")
    val order_client_address: String = "",
    @SerializedName("order_paytype_id")
    val order_paytype_id: Int = 0,
    @SerializedName("order_prod_id")
    val order_prod_id: Int = 0,
    @SerializedName("order_prod_count")
    val order_prod_count: Int = 0
)