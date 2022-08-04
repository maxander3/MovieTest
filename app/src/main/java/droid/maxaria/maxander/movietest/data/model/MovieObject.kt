package droid.maxaria.maxander.movietest.data.model

data class MovieObject(
    val items: List<Item>
){
    data class Item(
        val actors: List<Actor>,
        val directorName: String,
        val releaseYear: Int,
        val title: String
    ){
        data class Actor(
            val actorName: String
        )
    }
}



