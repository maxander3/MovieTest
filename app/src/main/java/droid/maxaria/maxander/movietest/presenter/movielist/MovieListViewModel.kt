package droid.maxaria.maxander.movietest.presenter.movielist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import droid.maxaria.maxander.movietest.domain.MovieRepository
import droid.maxaria.maxander.movietest.domain.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val repository: MovieRepository,
) : ViewModel() {

    private var _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>>
        get() = _movieList

    private var _error = MutableLiveData<Unit>()
    val error: LiveData<Unit>
        get() = _error

    fun loadMovieList() {
        viewModelScope.launch(Dispatchers.IO) {
            lateinit var movieList: List<Movie>
            kotlin.runCatching {
                movieList = repository.getMovieList()
            }
                .onSuccess {
                    _movieList.postValue(repository.sortMovieListByYear(movieList))
                }
                .onFailure {
                    _error.postValue(Unit)
                }
        }
    }
}