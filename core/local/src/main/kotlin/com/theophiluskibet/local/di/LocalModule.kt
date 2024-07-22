/*
 * Copyright 2024 Theophilus Kibet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.theophiluskibet.local.di

import android.content.Context
import androidx.room.Room
import com.theophiluskibet.local.dao.CharactersDao
import com.theophiluskibet.local.database.CharactersDatabase
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.InjectedParam
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.theophiluskibet.local")
class LocalModule {
    @Single
    fun provideDao(database: CharactersDatabase): CharactersDao = database.charactersDao()

    @Single
    fun provideDatabase(
        @InjectedParam context: Context,
    ): CharactersDatabase =
        Room.databaseBuilder(
            context,
            CharactersDatabase::class.java,
            "characters.db",
        ).fallbackToDestructiveMigration()
            .build()
}
