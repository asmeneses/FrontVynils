package com.example.frontvynils.models

enum class Genre(val description: String) {
    CLASSICAL("Classical"),
    SALSA("Salsa"),
    ROCK("Rock"),
    FOLK("Folk");

    companion object {
        fun fromDescription(desc: String): Genre? = values().find { it.description == desc }
    }
}

enum class RecordLabel(val description: String) {
    SONY("Sony Music"),
    EMI("EMI"),
    FUENTES("Discos Fuentes"),
    ELEKTRA("Elektra"),
    FANIA("Fania Records");

    companion object {
        fun fromDescription(desc: String): RecordLabel? = values().find { it.description == desc }
    }
}

data class Album(
    val id: Int,
    val name: String,
    val cover: String,
    var releaseDate: String,
    var description: String,
    var genre: String,
    val recordLabel: String
)
