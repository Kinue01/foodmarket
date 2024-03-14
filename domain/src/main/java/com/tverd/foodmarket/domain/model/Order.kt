package com.tverd.foodmarket.domain.model

class Order(
    val orderClientFirstname: String = "",
    val orderClientLastname: String = "",
    val orderClientMiddletname: String = "",
    val orderClientPhone: String = "",
    val orderClientAddress: String = "",
    val orderPaytypeId: Int = 0,
    val orderProdId: Int = 0,
    val orderProdCount: Int = 0
)