package com.pabelpm.cleanmarvelcharacters.data.repository

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.pabelpm.data.repository.MarvelCharactersRepository
import com.pabelpm.data.source.LocalDataSource
import com.pabelpm.data.source.RemoteDataSource
import com.pabelpm.domain.MarvelCharacter
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MarvelRepositoryTest {


    @Mock
    lateinit var localDataSource: LocalDataSource

    @Mock
    lateinit var remoteDataSource: RemoteDataSource

    lateinit var marvelCharactersRepository: MarvelCharactersRepository

    private val mockMarvelCharacter = MarvelCharacter("0", "https://example.com","Example", "Example description")

    @Before
    fun setUp() {
        marvelCharactersRepository =
            MarvelCharactersRepository(localDataSource, remoteDataSource)
    }

    @Test
    fun save_remote_data_to_local() {
        runBlocking {

            val remoteMarvelCharacters = listOf(mockMarvelCharacter)
            whenever(localDataSource.isEmpty()).thenReturn(true)
            whenever(remoteDataSource.getMarvelCharacters()).thenReturn(remoteMarvelCharacters)

            marvelCharactersRepository.getMarvelCharacters()

            verify(localDataSource).saveMarvelCharacters(remoteMarvelCharacters)
        }
    }

    @Test
    fun get_marvel_characters_from_local() {
        runBlocking {
            val localMarvelCharacters = listOf(mockMarvelCharacter)

            `when`(localDataSource.isEmpty()).thenReturn(false)
            `when`(localDataSource.getMarvelCharacters()).thenReturn(localMarvelCharacters)

            val result = marvelCharactersRepository.getMarvelCharacters()

            assertEquals(localMarvelCharacters, result)
        }
    }

    @Test
    fun save_remote_marvel_character_to_local() {
        runBlocking {

            val remoteMarvelCharacter = mockMarvelCharacter
            whenever(localDataSource.isEmpty()).thenReturn(true)
            whenever(remoteDataSource.getMarvelCharacter("001")).thenReturn(remoteMarvelCharacter)

            marvelCharactersRepository.getMarvelCharacter("001")

            verify(localDataSource).saveMarvelCharacter(remoteMarvelCharacter)
        }
    }


    @Test
    fun get_marvel_character_from_local() {
        runBlocking {
            val localMarvelCharacter = mockMarvelCharacter

            `when`(localDataSource.isEmpty()).thenReturn(false)
            `when`(localDataSource.getById("001")).thenReturn(localMarvelCharacter)

            val result = marvelCharactersRepository.getMarvelCharacter("001")

            assertEquals(localMarvelCharacter, result)
        }
    }
}
