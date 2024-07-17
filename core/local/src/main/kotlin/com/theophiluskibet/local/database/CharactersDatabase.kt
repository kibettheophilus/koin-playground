package com.theophiluskibet.local.database

abstract class CharactersDatabase {
    abstract fun charactersDao(): CharactersDao
}