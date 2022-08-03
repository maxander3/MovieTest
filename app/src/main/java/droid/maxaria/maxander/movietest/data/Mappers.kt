package droid.maxaria.maxander.movietest.data

import droid.maxaria.maxander.movietest.data.model.Actor
import droid.maxaria.maxander.movietest.data.model.MovieObject
import droid.maxaria.maxander.movietest.domain.model.MovieModel

internal fun MovieObject.toDomain():List<MovieModel>{
    val list = mutableListOf<MovieModel>()
    for (item in items){
        list.add(MovieModel(
            actors = actorsToString(item.actors),
            directorName = item.directorName,
            releaseYear = item.releaseYear,
            title = item.title
        ))
    }
    return list
}
private fun actorsToString(listActors: List<Actor>):List<String>{
    val list  = mutableListOf<String>()
    for (actor in listActors ){
        list.add(actor.actorName)
    }
    return list
}