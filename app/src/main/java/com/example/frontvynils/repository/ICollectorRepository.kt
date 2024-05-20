package com.example.frontvynils.repository

import com.example.frontvynils.models.Collector

interface ICollectorRepository {
    suspend fun getCollectors(): List<Collector>
}