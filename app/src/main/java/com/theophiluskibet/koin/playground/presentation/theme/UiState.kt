package com.theophiluskibet.koin.playground.presentation.theme

import com.theophiluskibet.domain.models.CharactersDomainModel

sealed interface UiState {
    data object Loading : UiState
    data class Success(val data: List<CharactersDomainModel>) : UiState
    data class Error(val message: String) : UiState
}