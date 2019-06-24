package com.example.kotlin_retrofit_coroutine.di

import com.example.kotlin_retrofit_coroutine.repo.MainRepository
import com.example.kotlin_retrofit_coroutine.repo.MainRepositoryImpl
import com.example.kotlin_retrofit_coroutine.ui.MainViewModel
import com.example.kotlin_retrofit_coroutine.network.remoteDatasourceModule
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


val appModule = module {

    viewModel { MainViewModel(get()) }

    single<MainRepository> {
        MainRepositoryImpl(
            get()
        )
    }

}

val allAppModule = listOf(appModule, remoteDatasourceModule)