package com.esraa.kodecokotlincoroutinesfundamentals.ui.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.esraa.kodecokotlincoroutinesfundamentals.data.model.Movie
import com.esraa.kodecokotlincoroutinesfundamentals.databinding.ItemMovieBinding
import com.esraa.kodecokotlincoroutinesfundamentals.di.MOVIE_IMAGE_BASE_PATH

class MoviesAdapter: RecyclerView.Adapter<MovieViewHolder>() {
    private val items = mutableListOf<Movie>()
    fun setData(newItems:List<Movie>){
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val  bind = ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(bind)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
       holder.showData(items[position])
    }

    override fun getItemCount(): Int  = items.size


}
class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root){
    fun showData(movie: Movie) = with(itemView){
        Glide.with(this)
            .load(MOVIE_IMAGE_BASE_PATH + movie.posterPath)
            .into(binding.movieImage)
    }
}