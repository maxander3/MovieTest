package droid.maxaria.maxander.movietest.data

import droid.maxaria.maxander.movietest.data.network.ApiProvider
import droid.maxaria.maxander.movietest.domain.MovieRepository
import droid.maxaria.maxander.movietest.domain.model.MovieModel


class MovieRepositoryImpl(private val apiProvider: ApiProvider) : MovieRepository {
    override suspend fun getMovieList(): List<MovieModel> {
        try {
            val response = apiProvider.movieObject().getMovieList()
            return response.body()!!.toDomain()
        } catch (e: Exception) {
            throw RuntimeException("123")
        }
    }
    private fun sortMovieListByYear(movieList: List<MovieModel>): List<MovieModel> {
        return movieList.sortedBy{ it.movieReleaseYear }.reversed()
    }
    private fun checkDuplicate(movieList: List<MovieModel>): List<MovieModel>? {
        for (item in movieList) {
            item.actorsOfMovie.distinct()
        }
        return movieList
    }

}