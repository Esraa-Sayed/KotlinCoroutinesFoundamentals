package com.esraa.kodecokotlincoroutinesfundamentals.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.esraa.kodecokotlincoroutinesfundamentals.data.model.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("SELECT * FROM movies")
    suspend fun getSavedMovies():List<Movie>
}