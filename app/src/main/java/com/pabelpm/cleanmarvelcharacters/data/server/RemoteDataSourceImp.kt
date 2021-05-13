package com.pabelpm.cleanmarvelcharacters.data.server

import com.pabelpm.cleanmarvelcharacters.data.mappers.toMarvelCharacter
import com.pabelpm.cleanmarvelcharacters.data.server.response.dto.MarvelCharacterResponseDto
import com.pabelpm.data.source.RemoteDataSource
import com.pabelpm.domain.MarvelCharacter
import retrofit2.Response

class RemoteDataSourceImp(private val webService: WebService) : RemoteDataSource {
    override suspend fun getMarvelCharacters(offset:Int): List<MarvelCharacter> {
        val response: Response<MarvelCharacterResponseDto>
        try {
           response =  webService.getAllCharacters(offset)
        } catch (t: Throwable) {
            throw t
        }
        if (!response.isSuccessful){

            val responseErrorBody = response.errorBody()
            if (responseErrorBody != null) {
                //try to parse to a custom ErrorObject
                return listOf()
            }
            return listOf()
        }
        val marvelCharacterResponseDto = response.body() as MarvelCharacterResponseDto
        return   marvelCharacterResponseDto.data.marvelCharacterDtos.map { it.toMarvelCharacter() }
    }

    override suspend fun getMarvelCharacter(id: String): MarvelCharacter {
        val response: Response<MarvelCharacterResponseDto>
        try {
            response =  webService.getCharacterByIdentifier(id)
        } catch (t: Throwable) {
            throw t
        }

        val marvelCharacterResponseDto = response.body() as MarvelCharacterResponseDto
        return   marvelCharacterResponseDto.data.marvelCharacterDtos.first().toMarvelCharacter()
    }
}