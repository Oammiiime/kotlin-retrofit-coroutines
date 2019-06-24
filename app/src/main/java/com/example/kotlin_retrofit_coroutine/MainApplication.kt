package com.example.kotlin_retrofit_coroutine

import android.app.Application
import com.example.kotlin_retrofit_coroutine.di.allAppModule
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // start Koin context
        startKoin(this, allAppModule)

    }
}