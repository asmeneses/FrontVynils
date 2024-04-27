package com.example.frontvynils.repository

import com.example.frontvynils.models.Album
import com.example.frontvynils.network.ApiService

class AlbumRepository(private val api: ApiService) {
    suspend fun getAlbums(): List<Album> {
        return api.getAllAlbums()
    }
}

// class AlbumRepository(private val api: ApiService) {
//     suspend fun getAlbums(): List<Album> {
//         return try {
//             api.getAllAlbums()
//         } catch (e: Exception) {
//             emptyList() // Retorna una lista vacía si hay un error.
//         }
//     }
// }

