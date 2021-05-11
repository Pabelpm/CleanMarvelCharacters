package com.pabelpm.cleanmarvelcharacters.data.repository


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
class MoviesRepositoryTest {


    @Mock
    lateinit var localDataSource: LocalDataSource

    @Mock
    lateinit var remoteDataSource: RemoteDataSource

    lateinit var marvelCharactersRepository: MarvelCharactersRepository

    private val mockMarvelCharacter = MarvelCharacter("0", "Example", "Example description")

    @Before
    fun setUp() {
        marvelCharactersRepository =
            MarvelCharactersRepository(localDataSource, remoteDataSource)
    }

    @Test
    fun `getPopularMovies gets from remote`() {
        runBlocking {
            val remoteMovies = listOf(mockMarvelCharacter)
            `when`(remoteDataSource.getMarvelCharacters()).thenReturn(remoteMovies)

            val result = marvelCharactersRepository.getMarvelCharacters()

            assertEquals(remoteMovies, result)
        }
    }
}
