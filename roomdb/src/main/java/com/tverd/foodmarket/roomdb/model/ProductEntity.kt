package com.tverd.foodmarket.roomdb.model

import android.graphics.drawable.Drawable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_product")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val prodId: Int = 0,
    @ColumnInfo(name = "prod_title")
    val prodTitle: String = "",
    @ColumnInfo(name = "prod_description")
    val prodDescription: String = "",
    @ColumnInfo(name = "prod_price")
    val prodPrice: Int = 0,
    @ColumnInfo(name = "prod_weight")
    val prodWeight: Int = 0,
    @ColumnInfo(name = "prod_image")
    val prodImage: String = "",
    @ColumnInfo(name = "prod_service_id")
    val prodServiceId: Int = 0
)