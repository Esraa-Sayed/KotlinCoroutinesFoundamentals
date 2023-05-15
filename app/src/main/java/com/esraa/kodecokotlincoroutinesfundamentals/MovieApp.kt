package com.esraa.kodecokotlincoroutinesfundamentals

import android.app.Application
import com.esraa.kodecokotlincoroutinesfundamentals.di.appModule
import com.esraa.kodecokotlincoroutinesfundamentals.di.networkingModule
import com.esraa.kodecokotlincoroutinesfundamentals.di.presenterModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MovieApp)
            modules(listOf(appModule(), networkingModule(), presenterModule()))
        }
    }
}