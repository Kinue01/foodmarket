package com.tverd.foodmarket.di

import com.tverd.foodmarket.data.repository.cart.CartRoomRepository
import com.tverd.foodmarket.data.repository.client.ClientRoomRepository
import com.tverd.foodmarket.data.repository.product.ProductRoomRepository
import com.tverd.foodmarket.roomdb.dao.*
import com.tverd.foodmarket.roomdb.db.FoodDatabase
import com.tverd.foodmarket.roomdb.mappers.*
import com.tverd.foodmarket.roomdb.repositoryimplementation.CartRoomRepositoryImpl
import com.tverd.foodmarket.roomdb.repositoryimplementation.ClientRoomRepositoryImpl
import com.tverd.foodmarket.roomdb.repositoryimplementation.ProductRoomRepositoryImpl
import com.tverd.foodmarket.roomdb.utils.RoomProvider
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val roomModule = module {

    single<FoodDatabase> {
        RoomProvider().provideDb(androidContext())
    }

    single<ClientDao> {
        RoomProvider().provideClientDao(get())
    }

    single<ProductDao> {
        RoomProvider().provideProductDao(get())
    }

    single<ClientRoomRepository> {
        ClientRoomRepositoryImpl(get(), get(), get(), get())
    }

    single<ClientEntityMapper> {
        ClientEntityMapper()
    }

    single<ProductEntityMapper> {
        ProductEntityMapper(get(), get())
    }

    single<ProductRoomRepository> {
        ProductRoomRepositoryImpl(get(), get(), get(), get())
    }

    single<ServiceDao> {
        RoomProvider().provideServiceDao(get())
    }

    single<ServiceEntityMapper> {
        ServiceEntityMapper()
    }

    single<CartDao> {
        RoomProvider().provideCartDao(get())
    }

    single<CartRoomRepository> {
        CartRoomRepositoryImpl(get(), get())
    }

    single<CartEntityMapper> {
        CartEntityMapper(get())
    }

    single<CurrClientDao> {
        RoomProvider().provideCurrClientDao(get())
    }

    single<CurrClientEntityMapper> {
        CurrClientEntityMapper()
    }

}