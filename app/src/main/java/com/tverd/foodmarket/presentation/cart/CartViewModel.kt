package com.tverd.foodmarket.presentation.cart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tverd.foodmarket.domain.model.Cart
import com.tverd.foodmarket.domain.usecases.DeleteCartItemByIdUseCase
import com.tverd.foodmarket.domain.usecases.DeleteCartItemsUseCase
import com.tverd.foodmarket.domain.usecases.GetCartItemsUseCase
import com.tverd.foodmarket.domain.usecases.GetLastClientUseCase
import kotlinx.coroutines.launch

class CartViewModel(
    private val getCartItemsUseCase: GetCartItemsUseCase,
    private val deleteCartItemsUseCase: DeleteCartItemsUseCase,
    private val deleteCartItemByIdUseCase: DeleteCartItemByIdUseCase,
    private val getLastClientUseCase: GetLastClientUseCase
) : ViewModel() {

    val prods = MutableLiveData<List<Cart>>()
    val isClient = MutableLiveData<Boolean>()

    fun checkClient() = viewModelScope.launch {
        val temp = getLastClientUseCase.execute()
        if (temp.clientId != 0) {
            isClient.value = true
        }
        else {
            isClient.value = false
        }
    }

    fun getCartItems() = viewModelScope.launch {
        prods.value = getCartItemsUseCase.execute()
    }

    fun deleteCartItem(id: Int) = viewModelScope.launch {
        deleteCartItemByIdUseCase.execute(id)
    }

    fun deleteCartItems() = viewModelScope.launch {
        deleteCartItemsUseCase.execute()
    }

}