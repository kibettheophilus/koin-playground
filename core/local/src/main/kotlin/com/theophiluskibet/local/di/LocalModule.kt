package com.theophiluskibet.local.di

import com.theophiluskibet.local.dao.CharactersDao
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class LocalModule {

    @Single
    class provideDao() = CharactersDatabase().charactersDao()
}