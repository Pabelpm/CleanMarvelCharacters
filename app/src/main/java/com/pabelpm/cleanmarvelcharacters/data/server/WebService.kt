package com.pabelpm.cleanmarvelcharacters.data.server

import com.pabelpm.cleanmarvelcharacters.data.server.response.dto.MarvelCharacterResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebService {

    @GET("v1/public/characters")
    suspend fun getAllCharacters(@Query("offset") offset:Int): Response<MarvelCharacterResponseDto>

    //The same response, response is a list
    @GET("v1/public/characters/{characterId}")
    suspend fun getCharacterByIdentifier(@Path(value = "characterId") characterId: String): Response<MarvelCharacterResponseDto>

}