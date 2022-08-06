package droid.maxaria.maxander.movietest.data

import droid.maxaria.maxander.movietest.data.network.MovieNw
import droid.maxaria.maxander.movietest.domain.model.Movie

internal fun List<MovieNw.Item>.toDomain(): List<Movie> = map { it.toDomain() }


internal fun MovieNw.Item.toDomain() = Movie(
    actorsOfMovie = actorsToString(actors),
    movieDirectorName = directorName,
    movieReleaseYear = releaseYear,
    movieName = title
)


private fun actorsToString(listActors: List<MovieNw.Item.Actor>): List<String> =
    listActors.map { it.actorName }