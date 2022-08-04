package droid.maxaria.maxander.movietest.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiProvider() {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun movieObject(): MovieApi = retrofit.create(MovieApi::class.java)

    companion object {
        private const val BASE_URL = "https://raw.githubusercontent.com/"
    }
}