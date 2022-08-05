package droid.maxaria.maxander.movietest.data

import com.google.gson.Gson
import droid.maxaria.maxander.movietest.data.model.MovieObject
import droid.maxaria.maxander.movietest.data.network.ApiProvider
import droid.maxaria.maxander.movietest.domain.MovieRepository
import droid.maxaria.maxander.movietest.domain.model.MovieModel
import javax.inject.Inject


class MovieRepositoryImpl @Inject constructor(private val apiProvider: ApiProvider) : MovieRepository {
    override suspend fun getMovieList(): List<MovieModel> {
        try {
            val response = Gson().fromJson(
                apiProvider.movieObject().getMovieList().string(), MovieObject::class.java
            )
            val responseList = response.items.apply {
                for (item in this) {
                    item.actors = item.actors.distinct()
                    item.directorName = parseDirectorNameToFCs(item.directorName)
                }
            }
            return responseList.toDomain()
        } catch (e: Exception) {
            throw RuntimeException("The server is not responding")
        }
    }


    private fun parseDirectorNameToFCs(directorName: String): String {
        val FCs = directorName.split(" ").toTypedArray()
        return "${FCs[2]} ${FCs[0][0]}.${FCs[1][0]}."
    }

}