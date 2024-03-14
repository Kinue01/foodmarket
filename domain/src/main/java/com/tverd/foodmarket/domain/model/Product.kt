package com.tverd.foodmarket.domain.model

import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Parcel
import android.os.Parcelable

class Product(
    val prod_id: Int = 0,
    val prod_title: String = "",
    val prod_description: String = "",
    val prod_price: Int = 0,
    val prod_weight: Int = 0,
    val prod_image: String = "",
    val prod_service: Service = Service()
) {

}