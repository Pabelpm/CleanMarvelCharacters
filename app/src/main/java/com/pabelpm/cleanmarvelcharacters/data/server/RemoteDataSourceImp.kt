package com.pabelpm.cleanmarvelcharacters.data.server

import com.pabelpm.cleanmarvelcharacters.data.mappers.toMarvelCharacter
import com.pabelpm.cleanmarvelcharacters.data.server.response.Resource
import com.pabelpm.cleanmarvelcharacters.data.server.response.ResponseHandler
import com.pabelpm.cleanmarvelcharacters.data.server.response.dto.MarvelCharacterDto
import com.pabelpm.cleanmarvelcharacters.data.server.response.dto.MarvelCharacterResponseDto
import com.pabelpm.data.source.RemoteDataSource
import com.pabelpm.domain.MarvelCharacter

class RemoteDataSourceImp(private val webService: WebService): RemoteDataSource {
    override suspend fun getMarvelCharacters(): List<MarvelCharacter> {
         return  webService.getAllCharacters()
            .data.marvelCharacterDtos.map { it.toMarvelCharacter() }
    }
}