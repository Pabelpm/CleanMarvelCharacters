package com.pabelpm.data.repository


import com.pabelpm.data.source.LocalDataSource
import com.pabelpm.data.source.RemoteDataSource
import com.pabelpm.domain.MarvelCharacter

class MarvelCharactersRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun getMarvelCharacters(): List<MarvelCharacter> {
        val offset = getOffset()
        val marvelCharacters = remoteDataSource.getMarvelCharacters(offset)
        if (marvelCharacters.isEmpty()) {
            localDataSource.saveOffset(0)
        } else if (!localDataSource.marvelCharacterExist(marvelCharacters.last().id)) {
            localDataSource.saveMarvelCharacters(marvelCharacters)
            localDataSource.saveOffset(marvelCharacters.size)
        } else {
            localDataSource.saveOffset(localDataSource.getMarvelCharacters().size)
        }
        return localDataSource.getMarvelCharacters()
    }

    suspend fun getMarvelCharacter(id: String): MarvelCharacter {
        return try {
            localDataSource.getById(id)
        } catch (e: Exception) {
            val marvelCharacter = remoteDataSource.getMarvelCharacter(id)
            localDataSource.saveMarvelCharacter(marvelCharacter)
            marvelCharacter
        }
    }

    private suspend fun getOffset(): Int {
        var offset = 0
        try {
            offset = localDataSource.getOffset()
        } catch (e: Exception) {
            print("Offset not setted, and return 0")
        }
        return offset
    }
}
