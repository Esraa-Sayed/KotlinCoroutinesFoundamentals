package com.esraa.kodecokotlincoroutinesfundamentals.domain.repository

import androidx.room.Dao
import com.esraa.kodecokotlincoroutinesfundamentals.data.api.MovieAPIService
import com.esraa.kodecokotlincoroutinesfundamentals.data.database.MovieDao
import com.esraa.kodecokotlincoroutinesfundamentals.data.model.Movie
import com.esraa.kodecokotlincoroutinesfundamentals.data.model.MoviesResponse
import com.esraa.kodecokotlincoroutinesfundamentals.di.API_KEY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


class MovieRepoImp(
    private val movieAPIService: MovieAPIService,
    private val movieDao: MovieDao
) : MovieRepo {
    override fun getMovies(onMoviesReceived: (List<Movie>) -> Unit, onError: (Throwable) -> Unit) {
        movieAPIService.getMovies(API_KEY).enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {
                val movies = response.body()?.movies ?: emptyList()
                if (movies.isNotEmpty())
                    movieDao.saveMovies(movies)
                onMoviesReceived(movies)
            }

            override fun onFailure(call: Call<MoviesResponse>, throwable: Throwable) {
                val getSavedData = movieDao.getSavedMovies()
                if (throwable is IOException && getSavedData.isNotEmpty()){
                    onMoviesReceived(getSavedData)
                }else{
                    onError(throwable)
                }
            }
        })
    }
}