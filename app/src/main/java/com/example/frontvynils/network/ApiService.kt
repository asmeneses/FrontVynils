package com.example.frontvynils.network

import retrofit2.http.GET
import com.example.frontvynils.models.Album

interface ApiService {
    @GET("albums")
    suspend fun getAllAlbums(): List<Album>
}
