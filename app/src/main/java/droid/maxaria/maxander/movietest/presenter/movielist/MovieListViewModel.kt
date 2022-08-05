package droid.maxaria.maxander.movietest.presenter.movielist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import droid.maxaria.maxander.movietest.domain.MovieRepository
import droid.maxaria.maxander.movietest.domain.model.MovieModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val repository: MovieRepository,
) : ViewModel() {
    
    private var _movieList = MutableLiveData<List<MovieModel>>()
    val movieList: LiveData<List<MovieModel>>
        get() = _movieList

    private var _error = MutableLiveData<Unit>()
    val error: LiveData<Unit>
        get() = _error

    fun loadMovieList() {
        viewModelScope.launch {
            try {
                val movieList = repository.getMovieList()
                _movieList.postValue(sortMovieListByYear(movieList))
            } catch (e: Exception) {
                _error.postValue(Unit)
            }
        }
    }

    private fun sortMovieListByYear(movieList: List<MovieModel>): List<MovieModel> {
        return movieList.sortedBy { it.movieReleaseYear }.reversed()
    }
}