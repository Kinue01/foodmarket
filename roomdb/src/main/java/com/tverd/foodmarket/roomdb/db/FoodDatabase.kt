package com.tverd.foodmarket.roomdb.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tverd.foodmarket.roomdb.dao.*
import com.tverd.foodmarket.roomdb.model.*

@Database(entities = [ClientEntity::class, ProductEntity::class, ServiceEntity::class, CartEntity::class, CurrClientEntity::class], version = 6)
abstract class FoodDatabase : RoomDatabase() {

    abstract fun clientDao(): ClientDao

    abstract fun productDao(): ProductDao

    abstract fun serviceDao(): ServiceDao

    abstract fun cartDao(): CartDao

    abstract fun currClientDao(): CurrClientDao

}