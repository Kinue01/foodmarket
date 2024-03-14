package com.tverd.foodmarket.remote.model

import com.google.gson.annotations.SerializedName

class ClientApi(@SerializedName("client_phone")
                  val clientPhone: String = "",
                     @SerializedName("client_firstname")
                  val clientFirstname: String = "",
                     @SerializedName("client_email")
                  val clientEmail: String = "",
                     @SerializedName("client_middlename")
                  val clientMiddlename: String = "",
                     @SerializedName("client_lastname")
                  val clientLastname: String = "",
                     @SerializedName("client_adress")
                  val clientAdress: String = "",
                     @SerializedName("client_id")
                  val clientId: Int = 0,
                     @SerializedName("client_password")
                  val clientPassword: String = "")