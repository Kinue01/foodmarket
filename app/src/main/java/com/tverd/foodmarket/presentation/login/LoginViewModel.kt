package com.tverd.foodmarket.presentation.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.tverd.foodmarket.domain.model.Client
import com.tverd.foodmarket.domain.model.ClientLogin
import com.tverd.foodmarket.domain.model.ClientRegistration
import com.tverd.foodmarket.domain.usecases.AddClientUseCase
import com.tverd.foodmarket.domain.usecases.DeleteClientUseCase
import com.tverd.foodmarket.domain.usecases.GetClientByEmailAndPassUseCase
import kotlinx.coroutines.launch

class LoginViewModel(
    private val getClientByEmailAndPassUseCase: GetClientByEmailAndPassUseCase
) : ViewModel() {

    val clientLog = MutableLiveData<ClientLogin>()
    val client = MutableLiveData<Client>()

    fun getClient() = viewModelScope.launch {
        if (clientLog.isInitialized)
            client.value = getClientByEmailAndPassUseCase.execute(clientLog.value!!)
    }

}