package droid.maxaria.maxander.movietest.data.network

import com.google.gson.annotations.SerializedName

data class MovieNw(
    @SerializedName("items")
    val items: List<Item>,
) {
    data class Item(
        @SerializedName("actors")
        var actors: List<Actor>,
        @SerializedName("directorName")
        var directorName: String,
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



