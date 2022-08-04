package droid.maxaria.maxander.movietest.data

import droid.maxaria.maxander.movietest.data.model.MovieObject
import droid.maxaria.maxander.movietest.domain.model.MovieModel

internal fun MovieObject.toDomain():List<MovieModel>{
    val list = mutableListOf<MovieModel>()
    for (item in items){
        list.add(MovieModel(
            actorsOfMovie = actorsToString(item.actors),
            movieDirectorName = item.directorName,
            movieReleaseYear = item.releaseYear,
            movieName = item.title
        ))
    }
    return list
}
internal fun actorsToString(listActors: List<MovieObject.Item.Actor>):List<String> =  listActors.map { it.actorName }