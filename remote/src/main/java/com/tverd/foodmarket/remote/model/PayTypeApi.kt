package com.tverd.foodmarket.remote.model

import com.google.gson.annotations.SerializedName

class PayTypeApi(
    @SerializedName("type_id")
    val type_id: Int = 0,
    @SerializedName("type_name")
    val type_name: String = ""
)