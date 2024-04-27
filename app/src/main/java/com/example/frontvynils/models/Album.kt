package com.example.frontvynils.models

import java.util.Date

enum class Genre(val description: String) {
    CLASSICAL("Classical"),
    SALSA("Salsa"),
    ROCK("Rock"),
    FOLK("Folk")
}

enum class RecordLabel(val description: String) {
    SONY("Sony Music"),
    EMI("EMI"),
    FUENTES("Discos Fuentes"),
    ELEKTRA("Elektra"),
    FANIA("Fania Records")
}

data class Album(
    val id: Int,
    val name: String,
    val cover: String,
    var releaseData: Date,
    var description: String,
    var genre: Genre,
    val recordLabel: RecordLabel
)
