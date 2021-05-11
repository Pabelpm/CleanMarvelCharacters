package com.pabelpm.data.repository


import com.pabelpm.data.source.LocalDataSource
import com.pabelpm.data.source.RemoteDataSource
import com.pabelpm.domain.MarvelCharacter

class MarvelCharactersRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun getMarvelCharacters(): List<MarvelCharacter> {
        return remoteDataSource.getMarvelCharacters()
    }
}