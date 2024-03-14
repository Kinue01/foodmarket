package com.tverd.foodmarket.roomdb.mappers

interface RoomMapper<T, V> {

    suspend fun mapFromEntity(type: T): V

    fun mapToEntity(type: V): T

}