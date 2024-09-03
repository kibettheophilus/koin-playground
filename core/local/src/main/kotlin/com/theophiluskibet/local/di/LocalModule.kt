/**
 * MIT License
 *
 * Copyright (c) 2024 Kibet Theo
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.theophiluskibet.local.di

import android.content.Context
import androidx.room.Room
import com.theophiluskibet.local.dao.CharactersDao
import com.theophiluskibet.local.database.CharactersDatabase
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.theophiluskibet.local")
class LocalModule {
    @Single
    fun provideDao(database: CharactersDatabase): CharactersDao = database.charactersDao()

    @Single
    fun provideDatabase(context: Context): CharactersDatabase =
        Room.databaseBuilder(
            context,
            CharactersDatabase::class.java,
            "characters.db",
        ).fallbackToDestructiveMigration()
            .build()
}
