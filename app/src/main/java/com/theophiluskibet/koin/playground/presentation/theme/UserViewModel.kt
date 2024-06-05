package com.theophiluskibet.koin.playground.presentation.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theophiluskibet.koin.playground.domain.User
import com.theophiluskibet.koin.playground.domain.UserRepository
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            _users.value = userRepository.getUsers()
        }
    }
}