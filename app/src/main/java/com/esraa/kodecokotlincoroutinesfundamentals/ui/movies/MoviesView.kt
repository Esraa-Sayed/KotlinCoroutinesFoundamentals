package com.esraa.kodecokotlincoroutinesfundamentals.ui.movies

import com.esraa.kodecokotlincoroutinesfundamentals.data.model.Movie

interface MoviesView {
    fun showMovies(movies:List<Movie>)
    fun showError(throwable: Throwable)
}