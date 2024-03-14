package com.tverd.foodmarket.remote.model

import com.google.gson.annotations.SerializedName

class ProductApi(
                   @SerializedName("prod_image")
                   val prodImage: String = "",
                   @SerializedName("prod_description")
                   val prodDescription: String = "",
                   @SerializedName("prod_weight")
                   val prodWeight: Int = 0,
                   @SerializedName("prod_price")
                   val prodPrice: Int = 0,
                   @SerializedName("prod_service_id")
                   val prodService: Int = 0,
                   @SerializedName("prod_title")
                   val prodTitle: String = "",
                   @SerializedName("prod_id")
                   val prodId: Int = 0
)