package com.tverd.foodmarket.data.mappers

interface BaseMapper<E, D> {

    fun mapFromClient(type: E): D

    fun mapToClient(type: D): E

}