package com.example.frontvynils.repository

import com.example.frontvynils.models.Musician

class MusicianRepositoryMock : IMusicianRepository {
    override suspend fun getMusicians(): List<Musician> {
        return listOf(
            Musician(1, "Kurt Kobain", "https://i.pinimg.com/564x/df/82/c4/df82c40ac0abbdea78c8567c44ac63fe.jpg", "Fue un influyente músico y compositor estadounidense, conocido principalmente como el vocalista y guitarrista principal de la banda Nirvana. Su impacto en la música alternativa y la cultura rock sigue siendo profundo, a pesar de su trágica muerte a los 27 años.", birthDate = "1974-10-14T05:00:00.000Z"),
            Musician(2, "Steven Taylor", "https://i.pinimg.com/564x/55/78/5d/55785dbf1567a8d5351dc9a44f8d4f98.jpg", "Es el carismático vocalista y líder de la legendaria banda de rock Aerosmith. Conocido por su voz poderosa, presencia escénica electrizante y estilo extravagante, Tyler ha sido una figura central en el rock desde los años 70 y consolidado como uno de los iconos más duraderos y reconocibles del género.", birthDate = "1964-11-19T05:00:00.000Z")
        )
    }

    override suspend fun getMusician(id: Int): Musician? {
        return Musician(
            id = id,
            name = "Kurt Kobain",
            image = "https://i.pinimg.com/564x/df/82/c4/df82c40ac0abbdea78c8567c44ac63fe.jpg",
            description = "Fue un influyente músico y compositor estadounidense, conocido principalmente como el vocalista y guitarrista principal de la banda Nirvana. Su impacto en la música alternativa y la cultura rock sigue siendo profundo, a pesar de su trágica muerte a los 27 años.",
            birthDate = "1994-10-14T05:00:00.000Z"
        )
    }

    override suspend fun postMusician(musician: Musician): Musician? {
        return musician
    }
}