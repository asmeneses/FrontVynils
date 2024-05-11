package com.example.frontvynils.network

import retrofit2.http.GET
import com.example.frontvynils.models.Album
import com.example.frontvynils.models.Collector

interface ApiService {
    @GET("albums")
    suspend fun getAllAlbums(): List<Album>

    @GET("collectors")
    suspend fun getAllCollectors(): List<Collector>
}
