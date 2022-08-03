package droid.maxaria.maxander.movietest.domain.model

data class MovieModel(
    val actors: List<String>,
    val directorName: String,
    val releaseYear: Int,
    val title: String
)