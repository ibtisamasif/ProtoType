package com.example.androidprototype.core

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PrototypeApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PrototypeApplication)
            modules(koinModules)
        }
    }
}