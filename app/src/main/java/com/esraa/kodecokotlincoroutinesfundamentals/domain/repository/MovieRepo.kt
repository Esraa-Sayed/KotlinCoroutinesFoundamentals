package com.esraa.kodecokotlincoroutinesfundamentals.domain.repository

import com.esraa.kodecokotlincoroutinesfundamentals.data.model.Movie

interface MovieRepo {
    suspend fun getMovies(): List<Movie>
}