package com.tverd.foodmarket.remote.api

import com.tverd.foodmarket.domain.model.ClientLogin
import com.tverd.foodmarket.domain.model.ClientRegistration
import com.tverd.foodmarket.remote.model.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @GET("api/product/read.php")
    suspend fun getProducts() : Response<List<ProductApi>>

    @GET("api/service/readbyid.php")
    suspend fun getService(
        @Query("service_id") id: Int
    ) : Response<ServiceApi>

    @GET("api/product/readbyid.php")
    suspend fun getProdById(
        @Query("prod_id") id: Int
    ): Response<ProductApi>

    @POST("api/client/create.php")
    suspend fun addClient(
        @Body data: ClientRegistration
    ): Response<com.tverd.foodmarket.remote.model.Response>

    @POST("api/client/readbyemailandpass.php")
    suspend fun getClientEmailPass(
        @Body data: ClientLogin
    ): Response<ClientApi>

    @POST("api/order/create.php")
    suspend fun addOrder(
        @Body data: OrderApi
    ): Response<Unit>

    @POST("api/orderbyclient/create.php")
    suspend fun addOrderByClient(
        @Body data: OrderByClientApi
    ): Response<Unit>

    @GET("api/paytype/read.php")
    suspend fun getPayTypes(): Response<List<PayTypeApi>>

}