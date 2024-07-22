package com.theophiluskibet.data.repos

import com.theophiluskibet.data.mappers.toDomain
import com.theophiluskibet.data.mappers.toEntity
import com.theophiluskibet.domain.models.CharactersDomainModel
import com.theophiluskibet.domain.repos.CharactersRepository
import com.theophiluskibet.local.dao.CharactersDao
import com.theophiluskibet.remote.api.CharactersApi
import org.koin.core.annotation.InjectedParam
import org.koin.core.annotation.Single

@Single
class CharactersRepositoryImpl(
    private val charactersApi: CharactersApi,
    private val charactersDao: CharactersDao
) : CharactersRepository {
    override suspend fun getCharacters(): List<CharactersDomainModel> {
        // return charactersApi.getCharacters().results.map { it.toDomain() }
        return if (charactersDao.getCharacters().isNotEmpty()) {
            charactersDao.getCharacters().map { it.toDomain() }
        } else {
            val results = charactersApi.getCharacters().results
            charactersDao.insertCharacters(results.map { it.toEntity() })
            results.map { it.toDomain() }
            // result.map { it.toDomain() }
        }
    }
}