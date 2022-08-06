package droid.maxaria.maxander.movietest.presenter

import android.content.Context
import droid.maxaria.maxander.movietest.R
import droid.maxaria.maxander.movietest.domain.model.Movie
import droid.maxaria.maxander.movietest.presenter.model.MovieUi

internal fun List<Movie>.toPresenter(context: Context) = map { it.toPresenter(context) }

internal fun Movie.toPresenter(context: Context) = MovieUi(
    movieName = movieName,
    movieDirectorName = String.format(
        context.getString(R.string.director_name),
        movieDirectorName
    ),
    movieReleaseYear = String.format(
        context.getString(R.string.movie_year),
        movieReleaseYear
    ),
    actorsOfMovie = String.format(
        context.getString(R.string.actors_name),
        actorsOfMovie.joinToString()
    )
)