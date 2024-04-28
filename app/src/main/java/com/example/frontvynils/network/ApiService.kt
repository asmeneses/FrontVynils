package com.example.frontvynils.network

import retrofit2.http.GET
import com.example.frontvynils.models.Album

interface ApiService {
    @GET("4a00198c-6b74-452c-b726-c0a6944381bc")
    //@GET("albums")
    suspend fun getAllAlbums(): List<Album>
}
