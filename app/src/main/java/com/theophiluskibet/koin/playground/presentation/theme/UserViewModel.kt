package com.theophiluskibet.koin.playground.presentation.theme

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theophiluskibet.domain.repos.CharactersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class UserViewModel(private val userRepository: CharactersRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> get() = _uiState

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            val results = userRepository.getCharacters()
            _uiState.update {
                UiState.Success(results)
            }
            Log.d("UserViewModel", "getUsers: $results")
        }
    }
}
