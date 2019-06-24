package com.example.kotlin_retrofit_coroutine.network

import com.example.kotlin_retrofit_coroutine.model.DataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {
    @GET("api/users")
    suspend fun getData(@Query("page") page :Int) : DataModel
}