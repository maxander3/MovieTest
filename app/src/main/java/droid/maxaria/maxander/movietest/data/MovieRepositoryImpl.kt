package droid.maxaria.maxander.movietest.data

import droid.maxaria.maxander.movietest.data.retrofit.ApiProvider
import droid.maxaria.maxander.movietest.domain.MovieRepository
import droid.maxaria.maxander.movietest.domain.model.MovieModel
import java.lang.RuntimeException


class MovieRepositoryImpl(private val apiProvider: ApiProvider):MovieRepository {
    override suspend fun getMovieList(): List<MovieModel> {
        val response = apiProvider.movieObject().getMovieList()
        return if (response.isSuccessful){
             response.body()!!.toDomain()
        }else {
            throw RuntimeException ("The server is not responding")
        }
    }
}