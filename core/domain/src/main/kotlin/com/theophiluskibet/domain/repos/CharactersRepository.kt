package com.theophiluskibet.domain.repos

import com.theophiluskibet.domain.models.CharactersDomainModel

interface CharactersRepository {
    suspend fun getCharacters(): List<CharactersDomainModel>
}
