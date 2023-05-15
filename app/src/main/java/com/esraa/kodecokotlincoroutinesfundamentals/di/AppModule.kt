package com.esraa.kodecokotlincoroutinesfundamentals.di

import com.esraa.kodecokotlincoroutinesfundamentals.data.database.MovieDateBase
import com.esraa.kodecokotlincoroutinesfundamentals.domain.repository.MovieRepo
import com.esraa.kodecokotlincoroutinesfundamentals.domain.repository.MovieRepoImp
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


fun appModule() = module{
    single {
        MovieDateBase.create(androidContext())
    }

    single {
        get<MovieDateBase>().movieDao()
    }

    single {
        MovieRepoImp(get(),get()) as MovieRepo
    }
}