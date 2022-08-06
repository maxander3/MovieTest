package droid.maxaria.maxander.movietest.presenter.movielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import droid.maxaria.maxander.movietest.databinding.ItemMovieBinding
import droid.maxaria.maxander.movietest.presenter.model.MovieUi
import javax.inject.Inject

class MovieAdapter @Inject constructor() : ListAdapter<MovieUi, MovieViewHolder>(movieDiffUtil) {

    var onMovieItemClickListener: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(ItemMovieBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onMovieItemClickListener?.invoke(getItem(position).movieName)
        }
        holder.apply {
            title.text = getItem(position).movieName
            year.text = getItem(position).movieReleaseYear
            director.text = getItem(position).movieDirectorName
            actors.text = getItem(position).actorsOfMovie
        }
    }
}


class MovieViewHolder(binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
    val title = binding.movieTitleTv
    val year = binding.movieYearTv
    val director = binding.directorNameTv
    val actors = binding.actorsNameTv
}

private val movieDiffUtil = object : DiffUtil.ItemCallback<MovieUi>() {
    override fun areItemsTheSame(oldItem: MovieUi, newItem: MovieUi): Boolean {
        return (oldItem.movieName == newItem.movieName) &&
                (oldItem.movieDirectorName == newItem.movieDirectorName) &&
                (oldItem.movieReleaseYear == newItem.movieReleaseYear) &&
                (oldItem.actorsOfMovie == newItem.actorsOfMovie)
    }

    override fun areContentsTheSame(oldItem: MovieUi, newItem: MovieUi): Boolean {
        return oldItem == newItem
    }
}