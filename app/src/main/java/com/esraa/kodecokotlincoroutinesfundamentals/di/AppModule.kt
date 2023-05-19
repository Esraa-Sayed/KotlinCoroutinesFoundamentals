package com.esraa.kodecokotlincoroutinesfundamentals.di

import com.esraa.kodecokotlincoroutinesfundamentals.ContentProvider.CoroutineContextProviderImp
import com.esraa.kodecokotlincoroutinesfundamentals.data.database.MovieDateBase
import com.esraa.kodecokotlincoroutinesfundamentals.domain.repository.MovieRepoImp
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


fun appModule() = module{
    single {
        CoroutineContextProviderImp(Dispatchers.IO)
    }
    single {
        MovieDateBase.create(androidContext())
    }

    single {
        get<MovieDateBase>().movieDao()
    }

    single {
        MovieRepoImp(get(),get())
    }
}