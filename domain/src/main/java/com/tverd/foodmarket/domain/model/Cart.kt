package com.tverd.foodmarket.domain.model

class Cart(
    val prodId: Int = 0,
    val prod_title: String = "",
    val prod_description: String = "",
    val prod_price: Int = 0,
    val prod_weight: Int = 0,
    val prod_image: String = "",
    val prod_service: Service = Service(),
    val prodCount: Int = 0
)