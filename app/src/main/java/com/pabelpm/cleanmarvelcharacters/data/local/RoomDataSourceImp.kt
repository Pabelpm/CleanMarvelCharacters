package com.pabelpm.cleanmarvelcharacters.data.local


import com.pabelpm.data.source.LocalDataSource
import com.pabelpm.domain.MarvelCharacter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataSourceImp() : LocalDataSource {
    override suspend fun saveMarvelCharacters(marvelCharacter: List<MarvelCharacter>) {
        TODO("Not yet implemented")
    }

    override suspend fun getMarvelCharacters(): List<MarvelCharacter> {
        TODO("Not yet implemented")
    }

    override suspend fun getById(id: Int): MarvelCharacter {
        TODO("Not yet implemented")
    }


}