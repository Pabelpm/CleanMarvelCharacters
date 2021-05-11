package com.pabelpm.usescases

import com.pabelpm.data.repository.MarvelCharactersRepository
import com.pabelpm.domain.MarvelCharacter

class GetMarvelCharacters (private val marvelCharacterRepository: MarvelCharactersRepository) {
    suspend fun invoke(): List<MarvelCharacter> = marvelCharacterRepository.getMarvelCharacters()
}