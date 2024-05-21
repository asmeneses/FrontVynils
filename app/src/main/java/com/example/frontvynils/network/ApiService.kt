package com.example.frontvynils.network

import com.example.frontvynils.models.Album
import com.example.frontvynils.models.Collector
import com.example.frontvynils.models.Musician

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("albums")
    suspend fun getAlbums(): List<Album>

    @GET("albums/{id}")
    suspend fun getAlbum(@Path("id") id: Int): Album

    @Headers("Content-Type: application/json")
    @POST("albums")
    suspend fun postAlbum(@Body album: Album): Album

    @GET("collectors")
    suspend fun getAllCollectors(): List<Collector>

    @GET("collectors/{id}")
    suspend fun getCollector(@Path("id") id: Int): Collector

    @Headers("Content-Type: application/json")
    @POST("collectors")
    suspend fun postCollector(@Body collector: Collector): Collector

    @GET("musicians")
    suspend fun getAllMusicians(): List<Musician>

    @GET("musicians/{id}")
    suspend fun getMusician(@Path("id") id: Int): Musician

    @Headers("Content-Type: application/json")
    @POST("musicians")
    suspend fun postMusician(@Body musician: Musician): Musician
}

