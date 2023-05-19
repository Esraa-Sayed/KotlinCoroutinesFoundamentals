package com.esraa.kodecokotlincoroutinesfundamentals.domain.repository

import com.esraa.kodecokotlincoroutinesfundamentals.ContentProvider.CoroutineContextProvider
import com.esraa.kodecokotlincoroutinesfundamentals.Utils.logCoroutine
import com.esraa.kodecokotlincoroutinesfundamentals.data.api.MovieAPIService
import com.esraa.kodecokotlincoroutinesfundamentals.data.database.MovieDao
import com.esraa.kodecokotlincoroutinesfundamentals.data.model.Movie
import com.esraa.kodecokotlincoroutinesfundamentals.di.API_KEY
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import kotlin.math.log


class MovieRepoImp(
    private val movieAPIService: MovieAPIService,
    private val movieDao: MovieDao,
    private val coroutineContextProvider: CoroutineContextProvider
) : MovieRepo {
    override suspend fun getMovies(): List<Movie> =
        withContext(coroutineContextProvider.context()) {
            logCoroutine()
            val cachedMoviesDeferred = async {
                logCoroutine()
                 movieDao.getSavedMovies() }
            val resultDeferred = async { movieAPIService.getMovies(API_KEY).execute() }
            val cachedMovies = cachedMoviesDeferred.await()
            val result = resultDeferred.await().body()?.movies
            result ?: cachedMovies

        }
}