package com.tverd.foodmarket.roomdb.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_currclient")
class CurrClientEntity(
    @PrimaryKey()
    val clientId: Int = 0,
    @ColumnInfo(name = "client_firstname")
    val clientFirstName: String = "",
    @ColumnInfo(name = "client_lastname")
    val clientLastName: String = "",
    @ColumnInfo(name = "client_middlename")
    val clientMiddleName: String = "",
    @ColumnInfo(name = "client_email")
    val clientEmail: String = "",
    @ColumnInfo(name = "client_password")
    val clientPassword: String = "",
    @ColumnInfo(name = "client_phone")
    val clientPhone: String = "",
    @ColumnInfo(name = "client_address")
    val clientAddress: String = ""
)