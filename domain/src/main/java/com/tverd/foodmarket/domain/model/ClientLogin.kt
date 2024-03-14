package com.tverd.foodmarket.domain.model

import com.google.gson.annotations.SerializedName

class ClientLogin(
    @SerializedName("client_email")
    val email: String,
    @SerializedName("client_password")
    val password: String
)