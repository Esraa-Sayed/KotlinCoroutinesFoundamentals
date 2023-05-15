package com.esraa.kodecokotlincoroutinesfundamentals.data.model

import com.google.gson.annotations.SerializedName

class MoviesResponse(
    @SerializedName("results") val movies: List<Movie>
)