package com.example.frontvynils.network

import com.example.frontvynils.models.Album
// import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    // @GET("albums")
    @GET("49f55df0-8067-4913-a49f-705674ecfcfb")
    suspend fun getAlbums(): List<Album>

    // @GET("albums/{id}")
    // suspend fun getAlbum(@Path("id") albumId: Int): Album
    @GET("3bf4f4aa-a7a4-4241-8358-43bb076c6d60")
    suspend fun getAlbum(): Album
}
