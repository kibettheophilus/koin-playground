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
package com.theophiluskibet.remote.di

import com.theophiluskibet.remote.utils.ANOTHER_BASE_URL
import com.theophiluskibet.remote.utils.ANOTHER_CLIENT
import com.theophiluskibet.remote.utils.RICKY_MORTY_BASEURL
import com.theophiluskibet.remote.utils.RICKY_MORTY_CLIENT
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.theophiluskibet.remote")
class RemoteModule {
    @Single
    @Named(RICKY_MORTY_CLIENT)
    fun provideRickyMortyClient() =
        HttpClient(OkHttp) {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                    },
                )
            }

            install(DefaultRequest) {
                url {
                    host = RICKY_MORTY_BASEURL
                }
            }
        }

    @Single
    @Named(ANOTHER_CLIENT)
    fun provideAnotherClient() =
        HttpClient(OkHttp) {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                    },
                )
            }

            install(DefaultRequest) {
                url {
                    host = ANOTHER_BASE_URL
                }
            }
        }
}
