package com.example.frontvynils.repository

import com.example.frontvynils.models.Collector
import com.example.frontvynils.network.ApiService
import com.example.frontvynils.network.RetrofitInstance

class CollectorRepository() : ICollectorRepository {
    private val api: ApiService = RetrofitInstance.api

    override suspend fun getCollectors(): List<Collector> {
        return try {
            api.getAllCollectors()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}