package com.pabelpm.data.source

import com.pabelpm.domain.MarvelCharacter

interface LocalDataSource {
    suspend fun saveMarvelCharacters(marvelCharacter: List<MarvelCharacter>)
    suspend fun getMarvelCharacters(): List<MarvelCharacter>
    suspend fun getById(id: Int): MarvelCharacter
}