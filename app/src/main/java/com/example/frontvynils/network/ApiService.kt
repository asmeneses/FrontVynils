package com.example.frontvynils.network

import com.example.frontvynils.models.Album
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("albums")
    suspend fun getAlbums(): List<Album>

    @GET("albums/{id}")
    suspend fun getAlbum(@Path("id") albumId: Int): Album

    @Headers("Content-Type: application/json")
    @POST("albums")
    suspend fun createAlbum(@Body album: Album): Album
}
