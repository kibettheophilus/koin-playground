package com.theophiluskibet.remote.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    val info: Info,
    val results: List<CharacterDto>
)

@Serializable
data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
//    @Contextual
//    val prev: Any
)

@Serializable
data class CharacterDto(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

@Serializable
data class Location(
    val name: String,
    val url: String
)

@Serializable
data class Origin(
    val name: String,
    val url: String
)