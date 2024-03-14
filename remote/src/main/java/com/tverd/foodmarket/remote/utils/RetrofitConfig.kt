package com.tverd.foodmarket.remote.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tverd.foodmarket.remote.api.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {

    fun configGson(): Gson {
        return GsonBuilder().setLenient().create()
    }

    fun configOkHttp3(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()
    }

    fun configRetrofitApi(): ApiService {
        return Retrofit.Builder().baseUrl("http://myfavorfood.onlinewebshop.net/").client(configOkHttp3()).addConverterFactory(GsonConverterFactory.create(configGson())).build().create(ApiService::class.java)
    }
}