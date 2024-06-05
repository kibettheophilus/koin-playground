package com.theophiluskibet.koin.playground.domain

interface UserRepository {
    suspend fun getUsers(): List<User>
}