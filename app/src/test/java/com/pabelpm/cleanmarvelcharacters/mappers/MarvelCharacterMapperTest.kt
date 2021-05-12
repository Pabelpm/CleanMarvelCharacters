package com.pabelpm.cleanmarvelcharacters.mappers

import com.pabelpm.cleanmarvelcharacters.data.local.LocalMarvelCharacter
import com.pabelpm.cleanmarvelcharacters.data.mappers.toLocalMarvelCharacter
import com.pabelpm.cleanmarvelcharacters.data.mappers.toMarvelCharacter
import com.pabelpm.cleanmarvelcharacters.data.server.response.dto.*
import com.pabelpm.domain.MarvelCharacter
import org.junit.Assert
import org.junit.Test

class MarvelCharacterMapperTest {
    private val mockLocalMarvelCharacter =
        LocalMarvelCharacter("0", "https://example.com", "Example", "Example description")
    private val mockMarvelCharacter =
        MarvelCharacter("0", "https://example.com", "Example", "Example description")
    private val mockMarvelCharacterDto = MarvelCharacterDto(
        "0",
        "Example",
        "Example description",
        "",
        "",
        listOf(),
        Thumbnail("https://example", "com"),
        Comics("", "", "", listOf()),
        Stories("", "", "", listOf()),
        Events("", "", "", listOf()),
        Series("", "", "", listOf())
    )

    @Test
    fun convert_marvelCharacterDto_to_marvelCharacter() {
        Assert.assertEquals(mockMarvelCharacter, mockMarvelCharacterDto.toMarvelCharacter())
    }

    @Test
    fun convert_marvelCharacter_to_localMarvelCharacter() {
        Assert.assertEquals(mockLocalMarvelCharacter, mockMarvelCharacter.toLocalMarvelCharacter())
    }

    @Test
    fun convert_localMarvelCharacter_to_marvelCharacter() {
        Assert.assertEquals(mockMarvelCharacter, mockLocalMarvelCharacter.toMarvelCharacter())
    }
}