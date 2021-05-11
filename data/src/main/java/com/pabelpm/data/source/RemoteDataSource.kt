package com.pabelpm.data.source

import com.pabelpm.domain.MarvelCharacter

interface RemoteDataSource {
    suspend fun getMarvelCharacters(): List<MarvelCharacter>
}