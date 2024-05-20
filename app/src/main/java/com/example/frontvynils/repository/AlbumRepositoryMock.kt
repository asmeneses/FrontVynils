package com.example.frontvynils.repository

import com.example.frontvynils.models.Album

class AlbumRepositoryMock : IAlbumRepository {
    override suspend fun getAlbums(): List<Album> {
        return listOf(
            Album(
                id = 1,
                name = "Buscando América",
                cover = "https://i.pinimg.com/564x/aa/5f/ed/aa5fed7fac61cc8f41d1e79db917a7cd.jpg",
                releaseDate = "1984-08-01T05:00:00.000Z",
                description = "Buscando América es el primer álbum de la banda de Rubén Blades y" +
                        "Seis del Solar lanzado en 1984. La producción, bajo el sello " +
                        "Elektra, fusiona diferentes ritmos musicales tales como la salsa, reggae, " +
                        "rock, y el jazz latino. El disco fue grabado en Eurosound Studios en " +
                        "Nueva York entre mayo y agosto de 1983.",
                genre = "Salsa",
                recordLabel = "Elektra",
            )
        )
    }

    override suspend fun getAlbum(id: Int): Album? {
        return Album(
            id = id,
            name = "Buscando América",
            cover = "https://i.pinimg.com/564x/aa/5f/ed/aa5fed7fac61cc8f41d1e79db917a7cd.jpg",
            releaseDate = "1984-08-01T05:00:00.000Z",
            description = "Buscando América es el primer álbum de la banda de Rubén Blades y" +
                    "Seis del Solar lanzado en 1984. La producción, bajo el sello " +
                    "Elektra, fusiona diferentes ritmos musicales tales como la salsa, reggae, " +
                    "rock, y el jazz latino. El disco fue grabado en Eurosound Studios en " +
                    "Nueva York entre mayo y agosto de 1983.",
            genre = "Salsa",
            recordLabel = "Elektra",
        )
    }

    override suspend fun postAlbum(album: Album): Album? {
        return album
    }
}