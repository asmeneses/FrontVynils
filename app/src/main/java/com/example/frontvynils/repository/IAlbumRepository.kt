package com.example.frontvynils.repository

import com.example.frontvynils.models.Album

interface IAlbumRepository {
    suspend fun getAlbums(): List<Album>
    suspend fun getAlbum(albumId: Int): Album?
    suspend fun createAlbum(album: Album): Album?
}