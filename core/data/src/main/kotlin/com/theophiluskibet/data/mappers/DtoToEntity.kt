package com.theophiluskibet.data.mappers

import com.theophiluskibet.local.entity.CharacterEntity
import com.theophiluskibet.remote.model.CharacterDto

fun CharacterDto.toEntity() =
    CharacterEntity(
        created = created,
        episode = episode,
        gender = gender,
        id = id,
        image = image,
        name = name,
        species = species,
        type = type,
        status = status,
        url = url,
    )
