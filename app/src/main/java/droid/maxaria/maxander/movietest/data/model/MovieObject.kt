package droid.maxaria.maxander.movietest.data.model

import com.google.gson.annotations.SerializedName

data class MovieObject(
    @SerializedName("items")
    val items: List<Item>,
) {
    data class Item(
        @SerializedName("actors")
        val actors: List<Actor>,
        @SerializedName("directorName")
        val directorName: String,
        @SerializedName("releaseYear")
        val releaseYear: Int,
        @SerializedName("title")
        val title: String,
    ) {
        data class Actor(
            @SerializedName("actorName")
            val actorName: String,
        )
    }
}



