package com.theophiluskibet.data.di

import com.theophiluskibet.data.repos.CharactersRepositoryImpl
import com.theophiluskibet.domain.repos.CharactersRepository
import com.theophiluskibet.local.dao.CharactersDao
import com.theophiluskibet.local.di.LocalModule
import com.theophiluskibet.remote.api.CharactersApi
import com.theophiluskibet.remote.di.RemoteModule
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.InjectedParam
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module(includes = [RemoteModule::class, LocalModule::class])
@ComponentScan("com.theophiluskibet.data")
class DataModule {

    @Single
    fun provideCharactersRepository(
        @InjectedParam charactersApi: CharactersApi,
        @InjectedParam charactersDao: CharactersDao
    ): CharactersRepository = CharactersRepositoryImpl(charactersApi, charactersDao)

}