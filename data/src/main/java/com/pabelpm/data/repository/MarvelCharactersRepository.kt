package com.pabelpm.data.repository


import com.pabelpm.data.source.LocalDataSource
import com.pabelpm.data.source.RemoteDataSource
import com.pabelpm.domain.MarvelCharacter
import java.util.logging.Logger

class MarvelCharactersRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun getMarvelCharacters(): List<MarvelCharacter> {
        if(localDataSource.isEmpty()){
            val marvelCharacters = remoteDataSource.getMarvelCharacters()
            localDataSource.saveMarvelCharacters(marvelCharacters)
        }
        return localDataSource.getMarvelCharacters()
    }

    suspend fun getMarvelCharacter(id:String): MarvelCharacter {
        if(localDataSource.isEmpty()){
            val marvelCharacter = remoteDataSource.getMarvelCharacter(id)
            localDataSource.saveMarvelCharacter(marvelCharacter)
        }
        return localDataSource.getById(id)
    }
}
