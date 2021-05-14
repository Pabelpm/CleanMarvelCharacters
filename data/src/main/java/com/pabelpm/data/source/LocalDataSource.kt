package com.pabelpm.data.source

import com.pabelpm.domain.MarvelCharacter

interface LocalDataSource {
    suspend fun marvelCharacterExist(id: String):Boolean
    suspend fun saveMarvelCharacter(marvelCharacter: MarvelCharacter)
    suspend fun saveMarvelCharacters(marvelCharacters: List<MarvelCharacter>)
    suspend fun saveOffset(offset:Int)
    suspend fun getOffset():Int
    suspend fun getMarvelCharacters(): List<MarvelCharacter>
    suspend fun getById(id: String): MarvelCharacter
}