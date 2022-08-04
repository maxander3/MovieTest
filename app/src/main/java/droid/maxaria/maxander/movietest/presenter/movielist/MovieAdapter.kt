package droid.maxaria.maxander.movietest.presenter.movielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import droid.maxaria.maxander.movietest.R
import droid.maxaria.maxander.movietest.databinding.ItemMovieBinding
import droid.maxaria.maxander.movietest.domain.model.MovieModel

class MovieAdapter : ListAdapter<MovieModel, MovieAdapter.MovieViewHolder>(movieDiffUtil) {

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
        //TODO обработчик нажатий отредактировать вывод
        holder.apply {
            title.text = getItem(position).movieName
            year.text = String.format(
                itemView.context.getString(R.string.movie_year),
                getItem(position).movieReleaseYear
            )
            director.text = String.format(
                itemView.context.getString(R.string.director_name),
                getItem(position).movieDirectorName
            )
            actors.text = String.format(
                itemView.context.getString(R.string.actors_name),
                getItem(position).actorsOfMovie.joinToString()
            )
        }
    }

    inner class MovieViewHolder(binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.movieTitleTv
        val year = binding.movieYearTv
        val director = binding.directorNameTv
        val actors = binding.actorsNameTv
    }

}

private val movieDiffUtil = object : DiffUtil.ItemCallback<MovieModel>() {
    override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
        return ((oldItem.actorsOfMovie == newItem.actorsOfMovie) && (oldItem.movieDirectorName == newItem.movieDirectorName)
                && (oldItem.movieReleaseYear == newItem.movieReleaseYear) && (oldItem.movieName == newItem.movieName))
    }

    override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
        return (oldItem == newItem)
    }
}