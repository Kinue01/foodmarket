package com.tverd.foodmarket.di

import com.tverd.foodmarket.data.repository.client.ClientApiRepository
import com.tverd.foodmarket.data.repository.order.OrderApiRepository
import com.tverd.foodmarket.data.repository.paytype.PaytypeApiRepository
import com.tverd.foodmarket.data.repository.product.ProductApiRepository
import com.tverd.foodmarket.remote.api.ApiService
import com.tverd.foodmarket.remote.mappers.*
import com.tverd.foodmarket.remote.repositoryimplementation.ClientApiRepositoryImpl
import com.tverd.foodmarket.remote.repositoryimplementation.OrderApiRepositoryImpl
import com.tverd.foodmarket.remote.repositoryimplementation.PaytypeApiRepositoryImp
import com.tverd.foodmarket.remote.repositoryimplementation.ProductApiRepositoryImpl
import com.tverd.foodmarket.remote.utils.RetrofitConfig
import org.koin.dsl.module

val networkModule = module {

    single<ProductApiRepository> {
        ProductApiRepositoryImpl(get(), get())
    }

    single<ProductApiMapper> {
        ProductApiMapper(get(), get() )
    }

    single<ServiceApiMapper> {
        ServiceApiMapper()
    }

    single<ClientApiRepository> {
        ClientApiRepositoryImpl(get(), get())
    }

    single<ClientApiMapper> {
        ClientApiMapper()
    }

    single<ApiService> {
        RetrofitConfig().configRetrofitApi()
    }

    single<OrderApiMapper> {
        OrderApiMapper()
    }

    single<OrderByClientApiMapper> {
        OrderByClientApiMapper(get())
    }

    single<PaytypeApiMapper> {
        PaytypeApiMapper()
    }

    single<OrderApiRepository> {
        OrderApiRepositoryImpl(get(), get(), get())
    }

    single<PaytypeApiRepository> {
        PaytypeApiRepositoryImp(get(), get())
    }

}