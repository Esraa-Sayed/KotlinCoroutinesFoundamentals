package com.esraa.kodecokotlincoroutinesfundamentals.di

import com.esraa.kodecokotlincoroutinesfundamentals.ui.movies.MoviePresenterImp
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun presenterModule() = module {
   viewModel {
        MoviePresenterImp(get())
    }
}