package com.tverd.foodmarket.roomdb.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_cart")
data class CartEntity(
    @PrimaryKey(autoGenerate = false)
    val prodId: Int = 0,
    @ColumnInfo(name = "prod_count")
    val prodCount: Int = 0
)