package com.esraa.kodecokotlincoroutinesfundamentals.ui.movies

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.esraa.kodecokotlincoroutinesfundamentals.data.model.Movie
import com.esraa.kodecokotlincoroutinesfundamentals.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(),MoviesView {
    private lateinit var binding:ActivityMainBinding
    private val presenter:MoviePresenter  by viewModel<MoviePresenterImp>()
    private val movieAdapter by lazy {
        MoviesAdapter()
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        presenter.setView(this)
    }

    private fun initUI() {
        binding.moviesList.apply {
            adapter = movieAdapter
            layoutManager =LinearLayoutManager(applicationContext)
        }
        binding.swipeToRefresh.setOnRefreshListener {
            presenter.getData()
        }
    }

    override fun showMovies(movies: List<Movie>) {
        movieAdapter.setData(movies)
        binding.swipeToRefresh.isRefreshing = false
    }

    override fun showError(throwable: Throwable) {
        binding.swipeToRefresh.isRefreshing = false
        Toast.makeText(this,"Can't load data",Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onStart() {
        super.onStart()
      presenter.getData()
    }

}