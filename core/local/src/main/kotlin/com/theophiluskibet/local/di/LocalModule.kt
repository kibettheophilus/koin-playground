package com.theophiluskibet.local.di

import android.content.Context
import androidx.room.Room
import com.theophiluskibet.local.dao.CharactersDao
import com.theophiluskibet.local.database.CharactersDatabase
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.InjectedParam
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import org.koin.core.context.KoinContext

@Module
@ComponentScan("com.theophiluskibet.local")
class LocalModule {

    @Single
    fun provideDao(database: CharactersDatabase): CharactersDao = database.charactersDao()

    @Single
    fun provideDatabase(
        @InjectedParam context: Context
    ): CharactersDatabase = Room.databaseBuilder(
        context,
        CharactersDatabase::class.java,
        "characters.db"
    ).fallbackToDestructiveMigration()
        .build()
}