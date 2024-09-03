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
package com.theophiluskibet.data.repos

import com.theophiluskibet.data.mappers.toDomain
import com.theophiluskibet.data.mappers.toEntity
import com.theophiluskibet.domain.models.CharactersDomainModel
import com.theophiluskibet.domain.repos.CharactersRepository
import com.theophiluskibet.local.dao.CharactersDao
import com.theophiluskibet.remote.api.CharactersApi
import org.koin.core.annotation.Single

@Single
class CharactersRepositoryImpl(
    private val charactersApi: CharactersApi,
    private val charactersDao: CharactersDao,
) : CharactersRepository {
    override suspend fun getCharacters(): List<CharactersDomainModel> {
        return if (charactersDao.getCharacters().isNotEmpty()) {
            charactersDao.getCharacters().map { it.toDomain() }
        } else {
            val results = charactersApi.getCharacters().results
            charactersDao.insertCharacters(results.map { it.toEntity() })
            results.map { it.toDomain() }
        }
    }
}
