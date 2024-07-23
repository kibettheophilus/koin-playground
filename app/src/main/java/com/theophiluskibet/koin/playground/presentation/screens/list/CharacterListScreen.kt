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
package com.theophiluskibet.koin.playground.presentation.screens.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharacterListScreen(
    modifier: Modifier = Modifier,
    onCharacterClick: (String) -> Unit,
    viewModel: CharacterListViewModel = koinViewModel(),
) {
    val uiState = viewModel.uiState.collectAsState().value
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        when (uiState) {
            is UiState.Loading -> CircularProgressIndicator(modifier = Modifier)
            is UiState.Error -> {
                Text(text = uiState.message)
            }

            is UiState.Success -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    items(uiState.data) { character ->
                        Text(text = character.name)
                    }
                }
            }
        }
    }
}
