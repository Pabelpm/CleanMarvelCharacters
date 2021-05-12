package com.pabelpm.cleanmarvelcharacters.data.mappers

import com.pabelpm.cleanmarvelcharacters.data.local.LocalMarvelCharacter
import com.pabelpm.cleanmarvelcharacters.data.server.response.dto.MarvelCharacterDto
import com.pabelpm.domain.MarvelCharacter


fun MarvelCharacterDto.toMarvelCharacter(): MarvelCharacter {
    return MarvelCharacter(id,createThumbnailPath(thumbnail.path,thumbnail.extension), name, description)
}

fun MarvelCharacter.toLocalMarvelCharacter(): LocalMarvelCharacter{
    return  LocalMarvelCharacter(id,url, name, description)
}

fun LocalMarvelCharacter.toMarvelCharacter(): MarvelCharacter{
    return MarvelCharacter(id,url ,name, description)
}


fun createThumbnailPath(path: String, extension: String): String {
    return (path).plus(".").plus(extension)
}