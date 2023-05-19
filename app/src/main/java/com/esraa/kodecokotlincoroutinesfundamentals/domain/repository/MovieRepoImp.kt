package com.esraa.kodecokotlincoroutinesfundamentals.domain.repository

import com.esraa.kodecokotlincoroutinesfundamentals.data.api.MovieAPIService
import com.esraa.kodecokotlincoroutinesfundamentals.data.database.MovieDao
import com.esraa.kodecokotlincoroutinesfundamentals.data.model.Movie
import com.esraa.kodecokotlincoroutinesfundamentals.di.API_KEY

class MovieRepoImp(
    private val movieAPIService: MovieAPIService,
    private val movieDao: MovieDao,
) : MovieRepo {
    override suspend fun getMovies(): List<Movie> {
        val cachedMovies = movieDao.getSavedMovies()
        try {

            val result = movieAPIService.getMovies(API_KEY).movies
            movieDao.saveMovies(result)
            return result
        } catch (error: Throwable) {
           error.printStackTrace()
        }
        return cachedMovies
    }
}