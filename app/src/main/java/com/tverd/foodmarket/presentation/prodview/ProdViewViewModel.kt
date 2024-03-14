package com.tverd.foodmarket.presentation.prodview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tverd.foodmarket.domain.model.Cart
import com.tverd.foodmarket.domain.model.Product
import com.tverd.foodmarket.domain.usecases.GetProductByIdUseCase
import com.tverd.foodmarket.domain.usecases.SaveToCartUseCase
import kotlinx.coroutines.launch

class ProdViewViewModel(
    private val getProductByIdUseCase: GetProductByIdUseCase,
    private val saveToCartUseCase: SaveToCartUseCase
) : ViewModel() {

    val currProd = MutableLiveData<Product>()
    val count = MutableLiveData<Int>()

    fun getProd(id: Int) = viewModelScope.launch {
        currProd.value = getProductByIdUseCase.execute(id)
    }

    fun addToCart() = viewModelScope.launch {
        saveToCartUseCase.execute(Cart(
            currProd.value!!.prod_id,
            currProd.value!!.prod_title,
            currProd.value!!.prod_description,
            currProd.value!!.prod_price,
            currProd.value!!.prod_weight,
            currProd.value!!.prod_image,
            currProd.value!!.prod_service,
            count.value!!
        ))
    }

}