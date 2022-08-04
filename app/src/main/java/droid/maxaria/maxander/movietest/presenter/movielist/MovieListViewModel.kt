package droid.maxaria.maxander.movietest.presenter.movielist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import droid.maxaria.maxander.movietest.data.MovieRepositoryImpl
import droid.maxaria.maxander.movietest.data.network.ApiProvider
import droid.maxaria.maxander.movietest.domain.model.MovieModel
import kotlinx.coroutines.launch

class MovieListViewModel : ViewModel() {
    // TODO: DI
    private val apiProvider = ApiProvider()
    private val repositoryImpl = MovieRepositoryImpl(apiProvider)

    private var _movieList = MutableLiveData<List<MovieModel>>()
    val movieList:LiveData<List<MovieModel>>
        get() = _movieList

    private var _error = MutableLiveData<Unit>()
    val error:LiveData<Unit>
        get() = _error

    fun loadMovieList() {
        viewModelScope.launch {
            try {
                val movieList = repositoryImpl.getMovieList()
                _movieList.postValue((movieList))
            } catch (e: Exception) {
                _error.postValue(Unit)
            }
        }
    }
}