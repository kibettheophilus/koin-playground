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
package com.theophiluskibet.data.repos

import com.theophiluskibet.data.mappers.toDomain
import com.theophiluskibet.domain.models.CharactersDomainModel
import com.theophiluskibet.domain.repos.CharactersRepository
import com.theophiluskibet.remote.api.CharactersApi
import org.koin.core.annotation.Single

@Single
class CharactersRepositoryImpl(
    private val charactersApi: CharactersApi,
    // private val charactersDao: CharactersDao,
) : CharactersRepository {
    override suspend fun getCharacters(): List<CharactersDomainModel> {
        return charactersApi.getCharacters().results.map { it.toDomain() }

        // TODO: uncomment to test
//        return if (charactersDao.getCharacters().isNotEmpty()) {
//            charactersDao.getCharacters().map { it.toDomain() }
//        } else {
//            val results = charactersApi.getCharacters().results
//            charactersDao.insertCharacters(results.map { it.toEntity() })
//            results.map { it.toDomain() }
//        }
    }
}
