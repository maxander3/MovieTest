package droid.maxaria.maxander.movietest.data.network

import retrofit2.Retrofit
import javax.inject.Inject

class ApiProvider @Inject constructor() {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .build()

    fun movieObject(): MovieApi = retrofit.create(MovieApi::class.java)

    companion object {
        private const val BASE_URL = "https://raw.githubusercontent.com/"
    }
}