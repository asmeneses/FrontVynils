package com.example.frontvynils.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Album(
    @SerializedName("id")
    @Expose(serialize = false, deserialize = true)
    val id: Int? = null,

    @SerializedName("name")
    val name: String,

    @SerializedName("cover")
    val cover: String,

    @SerializedName("releaseDate")
    var releaseDate: String,

    @SerializedName("description")
    var description: String,

    @SerializedName("genre")
    var genre: String,

    @SerializedName("recordLabel")
    val recordLabel: String
)
