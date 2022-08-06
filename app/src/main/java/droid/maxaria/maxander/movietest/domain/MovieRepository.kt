package droid.maxaria.maxander.movietest.domain

import droid.maxaria.maxander.movietest.domain.model.Movie

interface MovieRepository {
    suspend fun getMovieList(): List<Movie>

    suspend fun sortMovieListByYear(movieList: List<Movie>): List<Movie>
}