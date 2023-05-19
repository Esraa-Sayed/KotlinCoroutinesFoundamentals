package com.esraa.kodecokotlincoroutinesfundamentals.ui.movies

import com.esraa.kodecokotlincoroutinesfundamentals.Utils.logCoroutine
import com.esraa.kodecokotlincoroutinesfundamentals.domain.repository.MovieRepo
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MoviePresenterImp(private val  movieRepo: MovieRepo):MoviePresenter,CoroutineScope {
    private lateinit var moviesView: MoviesView
    private val parentJob = SupervisorJob()
    private val coroutineExceptionHandler = CoroutineExceptionHandler{ context, throwable ->
        throwable.stackTrace
    }
    override fun setView(moviesView: MoviesView) {
      this.moviesView = moviesView
    }

    override fun getData() {
        launch {
        logCoroutine()
           val result = runCatching {  movieRepo.getMovies() }
            result.onSuccess {
                moviesView.showMovies(it)
            }.onFailure {
                moviesView.showError(it)
            }
        }

    }

    override fun stop() {
        parentJob.cancelChildren()
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + parentJob + coroutineExceptionHandler
}