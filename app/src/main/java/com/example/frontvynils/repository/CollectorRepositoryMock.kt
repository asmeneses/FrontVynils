package com.example.frontvynils.repository

import com.example.frontvynils.models.Collector

class CollectorRepositoryMock : ICollectorRepository {
    override suspend fun getCollectors(): List<Collector> {
        return listOf(
            Collector(1, "Laura Puerta", "12345678", "laurapuerta@gmail.com"),
            Collector(2, "Mario Rios", "12345678", "mariorios@gmail.com")
        )
    }

    override suspend fun getCollector(id: Int): Collector? {
        return Collector(
            id = id,
            name = "Mario Rios",
            email = "mari@gmail.com",
            telephone = "1234567"
        )
    }
}