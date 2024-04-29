package com.example.frontvynils.models

import com.example.frontvynils.models.Album
import com.example.frontvynils.models.Genre
import com.example.frontvynils.models.RecordLabel
import java.util.Date
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    var nextId = 1

    fun generateNextId(): Int {
        return nextId++
    }

    print("Nombre: ")
    val name = scanner.nextLine()

    print("Ruta de la portada: ")
    val cover = scanner.nextLine()

    println("Fecha de lanzamiento (formato: yyyy-mm-dd): ")
    val releaseDateString = scanner.nextLine()
    val releaseDate = Date(releaseDateString)

    print("Descripción: ")
    val description = scanner.nextLine()

    println("Géneros disponibles:")
    Genre.values().forEachIndexed { index, genre ->
        println("$index. ${genre.description}")
    }
    print("Seleccione el género (Ingrese el número correspondiente): ")
    val genreIndex = scanner.nextInt()
    val genre = Genre.values()[genreIndex]
    scanner.nextLine()

    println("Sellos discográficos disponibles:")
    RecordLabel.values().forEachIndexed { index, label ->
        println("$index. ${label.description}")
    }
    print("Seleccione el sello discográfico (Ingrese el número correspondiente): ")
    val labelIndex = scanner.nextInt()
    val recordLabel = RecordLabel.values()[labelIndex]

    val id = generateNextId()

    val album = Album(
        id = id,
        name = name,
        cover = cover,
        releaseData = releaseDate,
        description = description,
        genre = genre,
        recordLabel = recordLabel
    )

    println("\nÁlbum agregado:")
    println("ID: ${album.id}")
    println("Nombre: ${album.name}")
    println("Portada: ${album.cover}")
    println("Fecha de lanzamiento: ${album.releaseData}")
    println("Descripción: ${album.description}")
    println("Género: ${album.genre.description}")
    println("Sello discográfico: ${album.recordLabel.description}")
}