package com.tverd.foodmarket.remote.mappers

interface EntityMapper<M, E> {

    suspend fun mapFromModel(model: M): E

}