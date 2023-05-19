package com.esraa.kodecokotlincoroutinesfundamentals.di

import com.esraa.kodecokotlincoroutinesfundamentals.ContentProvider.CoroutineContextProvider
import com.esraa.kodecokotlincoroutinesfundamentals.ContentProvider.CoroutineContextProviderImp
import com.esraa.kodecokotlincoroutinesfundamentals.data.database.MovieDateBase
import com.esraa.kodecokotlincoroutinesfundamentals.domain.repository.MovieRepo
import com.esraa.kodecokotlincoroutinesfundamentals.domain.repository.MovieRepoImp
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


fun appModule() = module{
    single {
        CoroutineContextProviderImp(Dispatchers.IO) as CoroutineContextProvider
    }
    single {
        MovieDateBase.create(androidContext())
    }

    single {
        get<MovieDateBase>().movieDao()
    }

    single {
        MovieRepoImp(get(),get(), get()) as MovieRepo
    }
}