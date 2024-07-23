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
package com.theophiluskibet.data.di

import com.theophiluskibet.data.repos.CharactersRepositoryImpl
import com.theophiluskibet.domain.repos.CharactersRepository
import com.theophiluskibet.local.dao.CharactersDao
import com.theophiluskibet.local.di.LocalModule
import com.theophiluskibet.remote.api.CharactersApi
import com.theophiluskibet.remote.di.RemoteModule
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.InjectedParam
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module(
    includes = [
        RemoteModule::class,
        LocalModule::class
    ]
)
@ComponentScan("com.theophiluskibet.data")
class DataModule
