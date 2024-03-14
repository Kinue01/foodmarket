package com.tverd.foodmarket.roomdb.utils

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tverd.foodmarket.roomdb.dao.*
import com.tverd.foodmarket.roomdb.db.FoodDatabase

class RoomProvider {

    fun provideDb(context: Context): FoodDatabase {
        return Room.databaseBuilder(context, FoodDatabase::class.java, "foodDb")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideClientDao(db: FoodDatabase): ClientDao {
        return db.clientDao()
    }

    fun provideProductDao(db: FoodDatabase): ProductDao {
        return db.productDao()
    }

    fun provideServiceDao(db: FoodDatabase): ServiceDao {
        return db.serviceDao()
    }

    fun provideCartDao(db: FoodDatabase): CartDao {
        return db.cartDao()
    }

    fun provideCurrClientDao(db: FoodDatabase): CurrClientDao {
        return db.currClientDao()
    }

}