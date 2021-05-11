package com.pabelpm.cleanmarvelcharacters.data.mappers

import com.pabelpm.cleanmarvelcharacters.data.server.response.dto.MarvelCharacterDto
import com.pabelpm.domain.MarvelCharacter


fun MarvelCharacterDto.toMarvelCharacter(): MarvelCharacter{
    return MarvelCharacter(id, name, description)
}