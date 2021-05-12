package com.pabelpm.cleanmarvelcharacters.data.mappers

import com.pabelpm.cleanmarvelcharacters.data.local.LocalMarvelCharacter
import com.pabelpm.cleanmarvelcharacters.data.server.response.dto.MarvelCharacterDto
import com.pabelpm.domain.MarvelCharacter


fun MarvelCharacterDto.toMarvelCharacter(): MarvelCharacter {
    return MarvelCharacter(id, name, description, createThumbnailPath(thumbnail.path,thumbnail.extension))
}

fun MarvelCharacter.toLocalMarvelCharacter(): LocalMarvelCharacter{
    return  LocalMarvelCharacter(id, name, description,url)
}

fun LocalMarvelCharacter.toMarvelCharacter(): MarvelCharacter{
    return MarvelCharacter(id, name, description,url)
}


fun createThumbnailPath(path: String, extension: String): String {
    return (path).plus(".").plus(extension)
}