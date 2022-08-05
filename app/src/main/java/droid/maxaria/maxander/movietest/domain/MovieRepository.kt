package droid.maxaria.maxander.movietest.domain

import droid.maxaria.maxander.movietest.domain.model.MovieModel

interface MovieRepository {
    suspend fun getMovieList(): List<MovieModel>
}