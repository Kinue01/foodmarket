package com.tverd.foodmarket.remote.model

import com.google.gson.annotations.SerializedName

class ServiceApi(
                      @SerializedName("service_name")
                      val serviceName: String = "",
                      @SerializedName("service_id")
                      val serviceId: Int = 0,
                      @SerializedName("service_image")
                      val serviceImage: String = ""
)