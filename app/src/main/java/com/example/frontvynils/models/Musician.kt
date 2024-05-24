package com.example.frontvynils.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.Date

data class Musician(
    @SerializedName("id")
    @Expose(serialize = false, deserialize = true)
    val id: Int? = null,

    @SerializedName("name")
    val name: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("description")
    var description: String,

    @SerializedName("birthDate")
    var birthDate: String
)
