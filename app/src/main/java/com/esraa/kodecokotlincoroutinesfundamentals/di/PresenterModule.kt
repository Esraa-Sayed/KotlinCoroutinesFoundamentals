package com.esraa.kodecokotlincoroutinesfundamentals.di

import com.esraa.kodecokotlincoroutinesfundamentals.ui.movies.MoviePresenter
import com.esraa.kodecokotlincoroutinesfundamentals.ui.movies.MoviePresenterImp
import org.koin.dsl.module

fun presenterModule() = module {
    single {
        MoviePresenterImp(get()) as MoviePresenter
    }
}