package com.theophiluskibet.local.dao

import com.theophiluskibet.local.entity.CharacterEntity
import org.koin.core.annotation.Single

interface CharactersDao {
    fun getCharacters(): List<CharacterEntity>
    fun insertCharacters(characters: List<CharacterEntity>)
}