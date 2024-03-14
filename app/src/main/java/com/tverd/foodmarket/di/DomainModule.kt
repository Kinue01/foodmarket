package com.tverd.foodmarket.di

import com.tverd.foodmarket.domain.usecases.*
import org.koin.dsl.module

val domainModule = module {

    factory<GetProductsUseCase> {
        GetProductsUseCase(get())
    }

    factory<GetProductByIdUseCase> {
        GetProductByIdUseCase(get())
    }

    factory<AddClientUseCase> {
        AddClientUseCase(get())
    }

    factory<GetClientByEmailAndPassUseCase> {
        GetClientByEmailAndPassUseCase(get())
    }

    factory<GetLastClientUseCase> {
        GetLastClientUseCase(get())
    }

    factory<DeleteClientUseCase> {
        DeleteClientUseCase(get())
    }

    factory<DeleteRoomProductsUseCase> {
        DeleteRoomProductsUseCase(get())
    }

    factory<GetCartItemsUseCase> {
        GetCartItemsUseCase(get())
    }

    factory<SaveToCartUseCase> {
        SaveToCartUseCase(get())
    }

    factory<DeleteCartItemsUseCase> {
        DeleteCartItemsUseCase(get())
    }

    factory<DeleteCartItemByIdUseCase> {
        DeleteCartItemByIdUseCase(get())
    }

    factory<AddOrderUseCase> {
        AddOrderUseCase(get())
    }

    factory<GetCartItemByIdUseCase> {
        GetCartItemByIdUseCase(get())
    }

    factory<GetPaytypesUseCase> {
        GetPaytypesUseCase(get())
    }

}