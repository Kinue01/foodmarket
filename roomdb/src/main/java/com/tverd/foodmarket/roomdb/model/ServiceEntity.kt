package com.tverd.foodmarket.roomdb.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_service")
data class ServiceEntity(
    @PrimaryKey(autoGenerate = true)
    val serviceId: Int = 0,
    @ColumnInfo(name = "service_name")
    val serviceName: String = "",
    @ColumnInfo(name = "service_image")
    val serviceImage: String = ""
)