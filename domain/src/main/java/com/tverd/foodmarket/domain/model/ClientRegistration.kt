package com.tverd.foodmarket.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ClientRegistration(
    @SerializedName("client_firstname")
    @Expose
    val client_firstname: String,
    @SerializedName("client_lastname")
    @Expose
    val client_lastname: String,
    @SerializedName("client_password")
    @Expose
    val client_password: String,
    @SerializedName("client_middlename")
    @Expose
    val client_middlename: String = "",
    @SerializedName("client_phone")
    @Expose
    val client_phone: String,
    @SerializedName("client_adress")
    @Expose
    val client_adress: String,
    @SerializedName("client_email")
    @Expose
    val client_email: String
)