package com.tverd.foodmarket.remote.model

import com.google.gson.annotations.SerializedName

class Response(
    @SerializedName("message")
    val message: String
)