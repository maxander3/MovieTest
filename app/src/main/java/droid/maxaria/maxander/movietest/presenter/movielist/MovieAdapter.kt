package droid.maxaria.maxander.movietest.presenter.movielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import droid.maxaria.maxander.movietest.databinding.ItemMovieBinding
import droid.maxaria.maxander.movietest.domain.model.MovieModel

class MovieAdapter: ListAdapter<MovieModel, MovieAdapter.MovieViewHolder>(movieDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(ItemMovieBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        //TODO обработчик нажатий отредактировать вывод
        holder.apply {
            title.text = getItem(position).movieName
            year.text = getItem(position).movieReleaseYear.toString()
            director.text = getItem(position).movieDirectorName
            actors.text = getItem(position).actorsOfMovie.toString()
        }
    }

    inner class MovieViewHolder(binding: ItemMovieBinding):RecyclerView.ViewHolder(binding.root){
        val title = binding.movieTitleTv
        val year = binding.movieYearTv
        val director = binding.directorNameTv
        val actors = binding.actorsNameTv
    }

}
private val movieDiffUtil = object:DiffUtil.ItemCallback<MovieModel>(){
    override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
        return ((oldItem.actorsOfMovie == newItem.actorsOfMovie)&&(oldItem.movieDirectorName == newItem.movieDirectorName)
                && (oldItem.movieReleaseYear == newItem.movieReleaseYear)&&(oldItem.movieName == newItem.movieName))
    }

    override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
        return (oldItem == newItem)
    }
}