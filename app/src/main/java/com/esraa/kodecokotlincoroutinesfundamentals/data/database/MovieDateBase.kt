package com.esraa.kodecokotlincoroutinesfundamentals.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.esraa.kodecokotlincoroutinesfundamentals.data.model.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MovieDateBase:RoomDatabase() {
    abstract fun movieDao():MovieDao

    companion object{
        fun create(context: Context):MovieDateBase{
            return Room.databaseBuilder(
                context,
                MovieDateBase::class.java,
                "movies"
            ).allowMainThreadQueries()
                .build()
        }
    }

}