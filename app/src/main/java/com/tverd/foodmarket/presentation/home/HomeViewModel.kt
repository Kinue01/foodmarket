package com.tverd.foodmarket.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tverd.foodmarket.domain.model.Product
import com.tverd.foodmarket.domain.usecases.GetProductsUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    val list = MutableLiveData<List<Product>>()

    fun getProds() = viewModelScope.launch {
        list.value = getProductsUseCase.execute()
    }

}