package droid.maxaria.maxander.movietest.data

import com.google.gson.Gson
import droid.maxaria.maxander.movietest.data.network.ApiProvider
import droid.maxaria.maxander.movietest.data.network.MovieNw
import droid.maxaria.maxander.movietest.domain.MovieRepository
import droid.maxaria.maxander.movietest.domain.model.Movie
import javax.inject.Inject


class MovieRepositoryImpl @Inject constructor(private val apiProvider: ApiProvider) :
    MovieRepository {
    override suspend fun getMovieList(): List<Movie> {
        try {
            val response = Gson().fromJson(
                apiProvider.movieObject().getMovieList().string(), MovieNw::class.java
            )
            val responseList = response.items.apply {
                for (item in this) {
                    item.actors = item.actors.distinct()
                    item.directorName = parseDirectorNameToSurnameInitials(item.directorName)
                }
            }
            return responseList.toDomain()
        } catch (e: Exception) {
            throw RuntimeException("The server is not responding")
        }
    }

    override suspend fun sortMovieListByYear(movieList: List<Movie>): List<Movie> {
        return movieList.sortedByDescending { it.movieReleaseYear }
    }

    private fun parseDirectorNameToSurnameInitials(directorName: String): String {
        val nameList = directorName.split(" ").toTypedArray()
        return "${nameList[2]} ${nameList[0][0]}.${nameList[1][0]}."
    }
}