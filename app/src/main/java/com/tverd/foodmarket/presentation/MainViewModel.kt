package com.tverd.foodmarket.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.tverd.foodmarket.data.repository.client.ClientRoomRepository
import com.tverd.foodmarket.data.repository.product.ProductRoomRepository
import com.tverd.foodmarket.domain.model.Client
import com.tverd.foodmarket.domain.usecases.DeleteRoomProductsUseCase
import com.tverd.foodmarket.domain.usecases.GetLastClientUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val deleteRoomProductsUseCase: DeleteRoomProductsUseCase,
    private val getLastClientUseCase: GetLastClientUseCase
) : ViewModel() {

    val currClient = MutableLiveData<Client>()

    fun delProds() = viewModelScope.launch {
        deleteRoomProductsUseCase.execute()
    }

    fun checkClient() = viewModelScope.launch {
        val temp = getLastClientUseCase.execute()
        if (temp.clientId != 0) {
            currClient.value = temp
        }
    }

}