package com.tverd.foodmarket.presentation.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tverd.foodmarket.domain.model.Client
import com.tverd.foodmarket.domain.model.ClientLogin
import com.tverd.foodmarket.domain.usecases.DeleteClientUseCase
import com.tverd.foodmarket.domain.usecases.GetClientByEmailAndPassUseCase
import com.tverd.foodmarket.domain.usecases.GetLastClientUseCase
import kotlinx.coroutines.launch

class AccountViewModel(
    private val getLastClientUseCase: GetLastClientUseCase,
    private val deleteClientUseCase: DeleteClientUseCase
) : ViewModel() {

    val isClient = MutableLiveData<Boolean>()
    val client = MutableLiveData<Client>()

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

    fun logout() = viewModelScope.launch {
        deleteClientUseCase.execute()
    }

}