package com.theophiluskibet.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.theophiluskibet.local.converters.ListConverter
import com.theophiluskibet.local.dao.CharactersDao
import com.theophiluskibet.local.entity.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1, exportSchema = false)
@TypeConverters(ListConverter::class)
abstract class CharactersDatabase : RoomDatabase() {
    abstract fun charactersDao(): CharactersDao
}