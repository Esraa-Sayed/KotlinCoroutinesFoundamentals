package com.esraa.kodecokotlincoroutinesfundamentals.ui.movies

import com.esraa.kodecokotlincoroutinesfundamentals.domain.repository.MovieRepo

class MoviePresenterImp(private val  movieRepo: MovieRepo):MoviePresenter {
    private lateinit var moviesView: MoviesView

    override fun setView(moviesView: MoviesView) {
      this.moviesView = moviesView
    }

    override fun getData() {
       movieRepo.getMovies(
           onMoviesReceived = {
               moviesView.showMovies(it)
           },
           onError = {
               moviesView.showError(it)
           }
       )
    }
}