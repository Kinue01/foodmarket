package com.tverd.foodmarket.di

import com.tverd.foodmarket.presentation.order.OrderViewModel
import com.tverd.foodmarket.presentation.login.LoginViewModel
import com.tverd.foodmarket.presentation.MainViewModel
import com.tverd.foodmarket.presentation.account.AccountViewModel
import com.tverd.foodmarket.presentation.cart.CartViewModel
import com.tverd.foodmarket.presentation.home.HomeViewModel
import com.tverd.foodmarket.presentation.prodview.ProdViewViewModel
import com.tverd.foodmarket.presentation.registration.RegistrationViewModel
import com.tverd.foodmarket.presentation.settings.SettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel> {
        MainViewModel(get(), get())
    }

    viewModel<SettingsViewModel> {
        SettingsViewModel()
    }

    viewModel<HomeViewModel> {
        HomeViewModel(get())
    }

    viewModel<ProdViewViewModel> {
        ProdViewViewModel(get(), get())
    }

    viewModel<AccountViewModel> {
        AccountViewModel(get(), get())
    }

    viewModel<LoginViewModel> {
        LoginViewModel(get())
    }

    viewModel<RegistrationViewModel> {
        RegistrationViewModel(get())
    }

    viewModel<CartViewModel> {
        CartViewModel(get(), get(), get(), get())
    }

    viewModel<OrderViewModel> {
        OrderViewModel(get(), get(), get(), get(), get(), get(), get())
    }

}