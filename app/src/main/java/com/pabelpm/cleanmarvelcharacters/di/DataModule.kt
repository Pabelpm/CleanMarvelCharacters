package com.pabelpm.cleanmarvelcharacters.di

import com.pabelpm.data.repository.MarvelCharactersRepository
import com.pabelpm.data.source.LocalDataSource
import com.pabelpm.data.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
class DataModule {

    @Provides
    fun marvelCharactersRepositoryProvider(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ) = MarvelCharactersRepository(localDataSource, remoteDataSource)
}