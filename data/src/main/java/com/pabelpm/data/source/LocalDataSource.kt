package com.pabelpm.data.source

import com.pabelpm.domain.MarvelCharacter

interface LocalDataSource {
    suspend fun isEmpty():Boolean
    suspend fun saveMarvelCharacter(marvelCharacter: MarvelCharacter)
    suspend fun saveMarvelCharacters(marvelCharacters: List<MarvelCharacter>)
    suspend fun getMarvelCharacters(): List<MarvelCharacter>
    suspend fun getById(id: String): MarvelCharacter
}