package com.example.frontvynils.repository

import com.example.frontvynils.models.Album
import com.example.frontvynils.network.ApiService
import com.example.frontvynils.network.RetrofitInstance

class AlbumRepository : IAlbumRepository {
    private val api: ApiService = RetrofitInstance.api

    override suspend fun getAlbums(): List<Album> {
        return try {
            api.getAlbums()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    override suspend fun getAlbum(id: Int): Album? {
        return try {
            api.getAlbum(id)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun postAlbum(album: Album): Album? {
        return try {
            api.postAlbum(album)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}