package com.example.frontvynils.repository

import com.example.frontvynils.models.Musician

interface IMusicianRepository {
    suspend fun getMusicians(): List<Musician>
    suspend fun getMusician(id: Int): Musician?
    suspend fun postMusician(musician: Musician): Musician?
}