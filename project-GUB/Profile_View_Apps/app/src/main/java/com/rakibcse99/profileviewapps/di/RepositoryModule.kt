package com.rakibcse99.profileviewapps.di

import com.rakibcse99.profileviewapps.repository.model.CharacterRepository
import com.rakibcse99.profileviewapps.repository.model.CharacterRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun provideCharacterRepository(preference: CharacterRepositoryImpl): CharacterRepository
}