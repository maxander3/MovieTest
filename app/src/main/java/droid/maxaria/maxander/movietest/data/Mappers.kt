package droid.maxaria.maxander.movietest.data

import droid.maxaria.maxander.movietest.data.model.MovieObject
import droid.maxaria.maxander.movietest.domain.model.MovieModel

internal fun List<MovieObject.Item>.toDomain(): List<MovieModel> {
    val list = mutableListOf<MovieModel>()
    for (item in listIterator()) {
        list.add(MovieModel(
            actorsOfMovie = actorsToString(item.actors),
            movieDirectorName = item.directorName,
            movieReleaseYear = item.releaseYear,
            movieName = item.title
        ))
    }
    return list
}

private fun actorsToString(listActors: List<MovieObject.Item.Actor>): List<String> =
    listActors.map { it.actorName }