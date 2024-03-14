package com.tverd.foodmarket.di

import com.tverd.foodmarket.data.mappers.ClientRegMapper
import com.tverd.foodmarket.data.repositoryimplementations.*
import com.tverd.foodmarket.domain.repository.*
import org.koin.dsl.module

val dataModule = module {

    single<ProductRepository> {
        ProductRepositoryImpl(get(), get())
    }

    single<ClientRepository> {
        ClientRepositoryImpl(get(), get())
    }

    single<ClientRegMapper> {
        ClientRegMapper()
    }

    single<CartRepository> {
        CartRepositoryImpl(get())
    }

    single<OrderRepository> {
        OrderRepositoryImpl(get(), get())
    }

    single<PaytypeRepository> {
        PaytypeRepositoryImpl(get())
    }

}