package com.example.frontvynils.repository

import com.example.frontvynils.models.Album

interface IAlbumRepository {
    suspend fun getAlbums(): List<Album>
    suspend fun getAlbum(id: Int): Album?
    suspend fun postAlbum(album: Album): Album?
}