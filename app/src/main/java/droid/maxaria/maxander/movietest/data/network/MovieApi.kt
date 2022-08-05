package droid.maxaria.maxander.movietest.data.network

import okhttp3.ResponseBody
import retrofit2.http.GET


interface MovieApi {

    @GET(PARAMETERS_URL)
    suspend fun getMovieList(): ResponseBody

    companion object {
        private const val PARAMETERS_URL =
            "constanta-android-dev/intership-wellcome-task/main/films.json"
    }
}