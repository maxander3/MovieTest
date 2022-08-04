package droid.maxaria.maxander.movietest.domain.model

data class MovieModel(
    val actorsOfMovie: List<String>,
    val movieDirectorName: String,
    val movieReleaseYear: Int,
    val movieName: String
)