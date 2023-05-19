package com.esraa.kodecokotlincoroutinesfundamentals.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esraa.kodecokotlincoroutinesfundamentals.Utils.logCoroutine
import com.esraa.kodecokotlincoroutinesfundamentals.domain.repository.MovieRepo
import kotlinx.coroutines.*

class MoviePresenterImp(private val  movieRepo: MovieRepo):ViewModel(), MoviePresenter {
    private lateinit var moviesView: MoviesView
    private val coroutineExceptionHandler = CoroutineExceptionHandler{ context, throwable ->
        throwable.stackTrace
    }
    override fun setView(moviesView: MoviesView) {
      this.moviesView = moviesView
    }

    override fun getData() {
        viewModelScope.launch(coroutineExceptionHandler) {
        logCoroutine()
           val result = runCatching {  movieRepo.getMovies() }
            result.onSuccess {
                moviesView.showMovies(it)
            }.onFailure {
                moviesView.showError(it)
            }
        }

    }
}