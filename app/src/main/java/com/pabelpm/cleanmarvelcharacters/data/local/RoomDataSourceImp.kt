package com.pabelpm.cleanmarvelcharacters.data.local


import com.pabelpm.cleanmarvelcharacters.data.mappers.toLocalMarvelCharacter
import com.pabelpm.cleanmarvelcharacters.data.mappers.toMarvelCharacter
import com.pabelpm.data.source.LocalDataSource
import com.pabelpm.domain.MarvelCharacter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RoomDataSourceImp @Inject constructor(private val marvelCharacterDao: MarvelCharacterDao, private val paginationOffsetDao: PaginationOffsetDao) : LocalDataSource {

    override suspend fun isEmpty(): Boolean {
       return withContext(Dispatchers.IO) { marvelCharacterDao.getAll().isEmpty() }
    }

    override suspend fun saveMarvelCharacters(marvelCharacters: List<MarvelCharacter>) {
        withContext(Dispatchers.IO) {marvelCharacterDao.saveMarvelCharacters(marvelCharacters.map { it.toLocalMarvelCharacter() })}
    }

    override suspend fun saveOffset(offset: Int) {
        val localPaginationOffset = LocalPaginationOffset(0,offset)
        withContext(Dispatchers.IO) {paginationOffsetDao.updateOffset(localPaginationOffset)}
    }

    override suspend fun getOffset():Int {
        return withContext(Dispatchers.IO) {paginationOffsetDao.getOffset().offset}
    }

    override suspend fun saveMarvelCharacter(marvelCharacter: MarvelCharacter) {
        withContext(Dispatchers.IO) { marvelCharacterDao.saveMarvelCharacter(marvelCharacter.toLocalMarvelCharacter())}
    }

    override suspend fun getMarvelCharacters(): List<MarvelCharacter> {
       return withContext(Dispatchers.IO) {
           marvelCharacterDao.getAll().map { it.toMarvelCharacter() }}
    }

    override suspend fun getById(id: String): MarvelCharacter {
        return withContext(Dispatchers.IO) {marvelCharacterDao.findById(id).toMarvelCharacter()}
    }
}