package com.pabelpm.usescases

import com.pabelpm.data.repository.MarvelCharactersRepository
import com.pabelpm.domain.MarvelCharacter

class GetMarvelCharacter(private val marvelCharacterRepository: MarvelCharactersRepository) {
    suspend fun invoke(id:String): MarvelCharacter = marvelCharacterRepository.getMarvelCharacter(id)
}