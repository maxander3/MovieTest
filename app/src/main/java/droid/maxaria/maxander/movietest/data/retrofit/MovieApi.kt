package droid.maxaria.maxander.movietest.data.retrofit

import droid.maxaria.maxander.movietest.data.model.MovieObject
import retrofit2.Response
import retrofit2.http.GET


interface MovieApi  {

    @GET(PARAMETERS_URL)
    suspend fun getMovieList():Response<MovieObject>

    companion object{
        private const val PARAMETERS_URL = "constanta-android-dev/intership-wellcome-task/main/films.json"
    }
}