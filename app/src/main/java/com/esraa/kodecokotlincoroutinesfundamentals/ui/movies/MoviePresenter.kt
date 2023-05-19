package com.esraa.kodecokotlincoroutinesfundamentals.ui.movies

interface MoviePresenter {
    fun setView(moviesView: MoviesView)
    fun getData()
}