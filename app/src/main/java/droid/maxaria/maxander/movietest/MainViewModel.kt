package droid.maxaria.maxander.movietest

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import droid.maxaria.maxander.movietest.data.MovieRepositoryImpl
import droid.maxaria.maxander.movietest.data.retrofit.ApiProvider
import droid.maxaria.maxander.movietest.domain.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    private val apiProvider = ApiProvider()
    private val repositoryImpl = MovieRepositoryImpl(apiProvider)

    fun getMovie(){
        viewModelScope.launch(Dispatchers.IO) {
            val movieList = repositoryImpl.getMovieList()
            Log.d("MainViewModel", movieList.toString())
        }
    }

}