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
class MarvelCharactersDetailsModule {

    @Provides
    fun marvelCharacterDetailsViewModelProvider(getMarvelCharacter: GetMarvelCharacter) =
        MarvelCharacterDetailsViewModel(getMarvelCharacter)

    @Provides
    fun getMarvelCharacterProvider(marvelCharactersRepository: MarvelCharactersRepository) =
        GetMarvelCharacter(marvelCharactersRepository)
}