package com.example.frontvynils.repository

import com.example.frontvynils.models.Album
import com.example.frontvynils.network.ApiService

class AlbumRepository(private val api: ApiService) : IAlbumRepository {
    override suspend fun getAlbums(): List<Album> {
        return try {
            api.getAlbums()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    override suspend fun getAlbum(albumId: Int): Album? {
        return try {
            api.getAlbum(albumId)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun createAlbum(album: Album): Album? {
        return try {
            api.createAlbum(album)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}