package com.example.frontvynils.repository

import com.example.frontvynils.models.Collector
import com.example.frontvynils.network.ApiService

class CollectorRepository(private val api: ApiService) {
    suspend fun getCollectors(): List<Collector> {
        return api.getAllCollectors()
    }
}