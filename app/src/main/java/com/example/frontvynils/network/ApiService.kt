package com.example.frontvynils.network

import retrofit2.http.GET
import com.example.frontvynils.models.Album

interface ApiService {
    @GET("f4b4dc09-f74d-4e38-a45a-8f628ea536be")
    //@GET("albums")
    suspend fun getAllAlbums(): List<Album>
}
