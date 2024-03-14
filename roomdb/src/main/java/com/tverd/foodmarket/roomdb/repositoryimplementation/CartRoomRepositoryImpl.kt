package com.tverd.foodmarket.roomdb.repositoryimplementation

import com.tverd.foodmarket.data.repository.cart.CartRoomRepository
import com.tverd.foodmarket.domain.model.Cart
import com.tverd.foodmarket.roomdb.dao.CartDao
import com.tverd.foodmarket.roomdb.mappers.CartEntityMapper

class CartRoomRepositoryImpl(
    private val cartDao: CartDao,
    private val cartEntityMapper: CartEntityMapper
) : CartRoomRepository {

    override suspend fun getCartItems(): List<Cart> {
        return cartDao.getCartItems().map {
            cartEntityMapper.mapFromEntity(it)
        }
    }

    override suspend fun saveToCart(cart: Cart) {
        cartDao.saveToCart(cartEntityMapper.mapToEntity(cart))
    }

    override suspend fun deleteCartItems() {
        cartDao.deleteCartItems()
    }

    override suspend fun deleteCartItemById(id: Int) {
        cartDao.deleteCartItemById(id)
    }

    override suspend fun getCartItemById(id: Int): Cart {
        return cartEntityMapper.mapFromEntity(cartDao.getCartItemById(id))
    }
}