package com.tverd.foodmarket.presentation.order

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tverd.foodmarket.domain.model.Cart
import com.tverd.foodmarket.domain.model.Client
import com.tverd.foodmarket.domain.model.Order
import com.tverd.foodmarket.domain.model.Paytype
import com.tverd.foodmarket.domain.usecases.*
import kotlinx.coroutines.launch

class OrderViewModel(
    private val getPaytypesUseCase: GetPaytypesUseCase,
    private val deleteCartItemsUseCase: DeleteCartItemsUseCase,
    private val deleteCartItemByIdUseCase: DeleteCartItemByIdUseCase,
    private val addOrderUseCase: AddOrderUseCase,
    private val getCartItemsUseCase: GetCartItemsUseCase,
    private val getLastClientUseCase: GetLastClientUseCase,
    private val getCartItemByIdUseCase: GetCartItemByIdUseCase
) : ViewModel() {

    val paytypes = MutableLiveData<List<Paytype>>()
    val order = MutableLiveData<Order>()
    val orders = MutableLiveData<List<Order>>()
    val products = MutableLiveData<List<Cart>>()
    val product = MutableLiveData<Cart>()
    val client = MutableLiveData<Client>()
    val isClient = MutableLiveData<Boolean>()
    val paytype = MutableLiveData<Paytype>()

    fun getTypes() = viewModelScope.launch {
        paytypes.value = getPaytypesUseCase.execute()
    }

    fun addOrders() = viewModelScope.launch {
        products.value = getCartItemsUseCase.execute()
        val list = mutableListOf<Order>()
        products.value!!.map {
           list.add(Order(
                client.value!!.clientFirstName,
                client.value!!.clientLastName,
                client.value!!.clientMiddleName,
                client.value!!.clientPhone,
                client.value!!.clientAddress,
                paytype.value!!.typeId,
                it.prodId,
                it.prodCount
            ))
        }
        orders.value = list
        orders.value!!.map {
            addOrderUseCase.execute(it)
        }
        deleteCartItemsUseCase.execute()
    }

    fun addOrder(id: Int) = viewModelScope.launch {
        product.value = getCartItemByIdUseCase.execute(id)
        order.value = Order(
            client.value!!.clientFirstName,
            client.value!!.clientLastName,
            client.value!!.clientMiddleName,
            client.value!!.clientPhone,
            client.value!!.clientAddress,
            paytype.value!!.typeId,
            product.value!!.prodId,
            product.value!!.prodCount
        )
        addOrderUseCase.execute(order.value!!)
        deleteCartItemByIdUseCase.execute(product.value!!.prodId)
    }

    fun checkClient() = viewModelScope.launch {
        val temp = getLastClientUseCase.execute()
        if (temp.clientId != 0) {
            isClient.value = true
            client.value = temp
        }
        else {
            isClient.value = false
        }
    }

}