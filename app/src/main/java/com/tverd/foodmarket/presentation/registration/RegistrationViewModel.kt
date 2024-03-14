package com.tverd.foodmarket.presentation.registration

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tverd.foodmarket.domain.model.ClientRegistration
import com.tverd.foodmarket.domain.usecases.AddClientUseCase
import kotlinx.coroutines.launch

class RegistrationViewModel(
    private val addClientUseCase: AddClientUseCase
) : ViewModel() {

    val client = MutableLiveData<ClientRegistration>()

    fun addClient() = viewModelScope.launch {
        if (client.isInitialized)
            addClientUseCase.execute(client.value!!)
    }

}