package com.tverd.foodmarket.domain.model

class Client(
    val clientId: Int = 0,
    val clientEmail: String = "",
    val clientPassword: String = "",
    val clientFirstName: String = "",
    val clientLastName: String = "",
    val clientMiddleName: String = "",
    val clientPhone: String = "",
    val clientAddress: String = ""
)