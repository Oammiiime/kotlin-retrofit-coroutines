package com.example.kotlin_retrofit_coroutine.network

import com.example.kotlin_retrofit_coroutine.network.DatasourceProperties.SERVER_URL
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val remoteDatasourceModule = module {
    single { createOkHttpClient() }

    single { createWebService<ServiceApi>(get(), SERVER_URL) }
}

object DatasourceProperties {
    const val SERVER_URL = "https://reqres.in/"
}

fun createOkHttpClient(): OkHttpClient {
       return getOkHttpClient()
}

fun getOkHttpClient(): OkHttpClient {
    val builder = OkHttpClient.Builder()
    //Create a new Interceptor.
    val headerAuthorizationInterceptor = object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
            var request = chain.request()
            return chain.proceed(request)
        }
    }
    builder.addInterceptor(headerAuthorizationInterceptor)
    return builder.build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
    return retrofit.create(T::class.java)
}

