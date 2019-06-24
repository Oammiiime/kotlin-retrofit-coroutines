package com.example.kotlin_retrofit_coroutine.repo

import com.example.kotlin_retrofit_coroutine.model.DataModel
import com.example.kotlin_retrofit_coroutine.network.ServiceApi

interface MainRepository {
    suspend fun getData(page: Int): DataModel
}

class MainRepositoryImpl(private val service: ServiceApi) : MainRepository {
    override suspend fun getData(page: Int): DataModel {
        return service.getData(page)
    }
}
