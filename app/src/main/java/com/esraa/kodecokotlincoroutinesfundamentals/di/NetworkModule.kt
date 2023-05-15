package com.esraa.kodecokotlincoroutinesfundamentals.di

import com.esraa.kodecokotlincoroutinesfundamentals.BuildConfig
import com.esraa.kodecokotlincoroutinesfundamentals.data.api.MovieAPIService
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.themoviedb.org/"
const val API_KEY = BuildConfig.API_KEY
const val MOVIE_IMAGE_BASE_PATH = "https://image.tmdb.org/t/p/w500"
fun networkingModule() = module {
    single {
        OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        ).build()
    }

    single {
        GsonConverterFactory.create()
    }

    single {
        Retrofit.Builder()
            .addConverterFactory(get<GsonConverterFactory>())
            .client(get<OkHttpClient>())
            .baseUrl(BASE_URL)
            .build()
    }

    single {
        get<Retrofit>().create(MovieAPIService::class.java)
    }
}