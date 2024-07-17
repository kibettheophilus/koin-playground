package com.theophiluskibet.remote.api

import com.theophiluskibet.remote.model.CharacterResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.koin.core.annotation.Single

@Single
class CharactersApi(private val client: HttpClient) {
    suspend fun getCharacters(): CharacterResponse =
        client.get("https://rickandmortyapi.com/api/character").body()
}