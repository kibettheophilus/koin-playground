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
package com.theophiluskibet.remote.api

import com.theophiluskibet.remote.model.CharacterResponse
import com.theophiluskibet.remote.utils.ANOTHER_CLIENT
import com.theophiluskibet.remote.utils.RICKY_MORTY_CLIENT
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Single
class CharactersApi(
    @Named(RICKY_MORTY_CLIENT) private val rickyMortyClient: HttpClient,
    @Named(ANOTHER_CLIENT) private val anotherClient: HttpClient,
) {
    suspend fun getCharacters(): CharacterResponse = rickyMortyClient.get("character").body()

    suspend fun getSomething() = anotherClient.get("home").bodyAsText()
}
