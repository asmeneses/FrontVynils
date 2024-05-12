package com.example.frontvynils.repository

import com.example.frontvynils.models.Album
import com.example.frontvynils.network.ApiService

class AlbumRepository(private val api: ApiService) : IAlbumRepository {
    override suspend fun getAlbums(): List<Album> {
        return try {
            api.getAlbums()
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getAlbum(albumId: Int): Album? {
        return try {
            api.getAlbum()
        } catch (e: Exception) {
            null
        }
    }
}