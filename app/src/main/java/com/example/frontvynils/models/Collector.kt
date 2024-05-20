package com.example.frontvynils.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Collector(
    @SerializedName("id")
    @Expose(serialize = false, deserialize = true)
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("telephone")
    val telephone: String,

    @SerializedName("email")
    val email: String
)