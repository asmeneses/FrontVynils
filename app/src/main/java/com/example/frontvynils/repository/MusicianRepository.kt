package com.example.frontvynils.repository

import com.example.frontvynils.models.Musician
import com.example.frontvynils.network.ApiService
import com.example.frontvynils.network.RetrofitInstance

class MusicianRepository() : IMusicianRepository {
    private val api: ApiService = RetrofitInstance.api

    override suspend fun getMusicians(): List<Musician> {
        return try {
            api.getAllMusicians()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    override suspend fun getMusician(id: Int): Musician? {
        return try {
            api.getMusician(id)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun postMusician(musician: Musician): Musician? {
        return try {
            api.postMusician(musician)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}