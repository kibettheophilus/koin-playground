package com.theophiluskibet.koin.playground.data

import com.theophiluskibet.koin.playground.domain.User
import com.theophiluskibet.koin.playground.domain.UserRepository
import org.koin.core.annotation.Single

@Single
class UserRepositoryImpl : UserRepository {
    override suspend fun getUsers(): List<User> {
        return listOf(
            User("Theo"),
            User("Kibet")
        )
    }
}