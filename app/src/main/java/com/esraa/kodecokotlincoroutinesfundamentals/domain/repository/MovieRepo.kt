package com.esraa.kodecokotlincoroutinesfundamentals.domain.repository

import com.esraa.kodecokotlincoroutinesfundamentals.data.model.Movie

interface MovieRepo {
    fun getMovies(
        onMoviesReceived:(List<Movie>) -> Unit,
        onError:(Throwable) -> Unit
    )
}