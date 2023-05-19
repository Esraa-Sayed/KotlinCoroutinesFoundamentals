package com.esraa.kodecokotlincoroutinesfundamentals.data.api

import com.esraa.kodecokotlincoroutinesfundamentals.data.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPIService {
    @GET("/3/movie/popular")
    suspend fun getMovies(@Query("api_key") apiKey:String): MoviesResponse
}