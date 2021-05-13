package com.pabelpm.cleanmarvelcharacters.di

import com.pabelpm.cleanmarvelcharacters.ui.main.MainViewModel
import com.pabelpm.cleanmarvelcharacters.ui.marvelcharacterdetails.MarvelCharacterDetailsViewModel
import com.pabelpm.data.repository.MarvelCharactersRepository
import com.pabelpm.usescases.GetMarvelCharacter
import com.pabelpm.usescases.GetMarvelCharacters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class MainActivityModule {

    @Provides
    fun mainViewModelProvider(getMarvelCharacters: GetMarvelCharacters) =
        MainViewModel(getMarvelCharacters)

    @Provides
    fun getMarvelCharactersProvider(marvelCharactersRepository: MarvelCharactersRepository) =
        GetMarvelCharacters(marvelCharactersRepository)
}