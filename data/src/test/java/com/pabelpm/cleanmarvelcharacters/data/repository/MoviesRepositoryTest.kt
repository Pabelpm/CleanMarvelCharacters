package com.pabelpm.cleanmarvelcharacters.data.repository

import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.pabelpm.data.repository.MarvelCharactersRepository
import com.pabelpm.data.source.LocalDataSource
import com.pabelpm.data.source.RemoteDataSource
import com.pabelpm.domain.MarvelCharacter
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.runners.MockitoJUnitRunner
import java.lang.Exception

@RunWith(MockitoJUnitRunner::class)
class MarvelRepositoryTest {


    @Mock
    lateinit var localDataSource: LocalDataSource

    @Mock
    lateinit var remoteDataSource: RemoteDataSource

    lateinit var marvelCharactersRepository: MarvelCharactersRepository

    private val mockMarvelCharacter = MarvelCharacter("0", "https://example.com","Example", "Example description")

    private lateinit var remoteMarvelCharacters : List<MarvelCharacter>

    @Before
    fun setUp() {

        marvelCharactersRepository =
            MarvelCharactersRepository(localDataSource, remoteDataSource)
        runBlocking {
            whenever(localDataSource.getOffset()).thenReturn(0)
            remoteMarvelCharacters = listOf(mockMarvelCharacter)
            whenever(remoteDataSource.getMarvelCharacters(0)).thenReturn(remoteMarvelCharacters)
        }
    }

    @Test
    fun save_remote_data_to_local() {
        runBlocking {

            whenever(localDataSource.getMarvelCharacters()).thenReturn(listOf())
            whenever(localDataSource.marvelCharacterExist("0")).thenReturn(false)

            marvelCharactersRepository.getMarvelCharacters()

            verify(localDataSource).saveMarvelCharacters(remoteMarvelCharacters)
        }
    }

    @Test
    fun get_marvel_characters_from_local() {
        runBlocking {
            val localMarvelCharacters = listOf(mockMarvelCharacter)

            whenever(localDataSource.getMarvelCharacters()).thenReturn(localMarvelCharacters)
            whenever(localDataSource.marvelCharacterExist("0")).thenReturn(true)
            whenever(localDataSource.saveOffset(0))

            val result = marvelCharactersRepository.getMarvelCharacters()

            assertEquals(localMarvelCharacters, result)
        }
    }

    @Test
    @Ignore ("Problems with try catch management")
    fun save_remote_marvel_character_to_local() {
        runBlocking {
            whenever(localDataSource.getById("0")).thenReturn(null)
            val remoteMarvelCharacter = mockMarvelCharacter
            whenever(remoteDataSource.getMarvelCharacter("0")).thenReturn(remoteMarvelCharacter)

            marvelCharactersRepository.getMarvelCharacter("0")

            verify(localDataSource).saveMarvelCharacter(remoteMarvelCharacter)
        }
    }


    @Test
    fun get_marvel_character_from_local() {
        runBlocking {
            val localMarvelCharacter = mockMarvelCharacter

            `when`(localDataSource.getById("0")).thenReturn(localMarvelCharacter)

            val result = marvelCharactersRepository.getMarvelCharacter("0")

            assertEquals(localMarvelCharacter, result)
        }
    }
}
