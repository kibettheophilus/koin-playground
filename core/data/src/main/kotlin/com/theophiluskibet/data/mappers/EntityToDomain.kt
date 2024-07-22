package com.theophiluskibet.data.mappers

import com.theophiluskibet.domain.models.CharactersDomainModel
import com.theophiluskibet.local.entity.CharacterEntity

fun CharacterEntity.toDomain() =
    CharactersDomainModel(
        created = created,
        episode = episode,
        gender = gender,
        id = id,
        image = image,
        name = name,
        species = species,
        status = status,
        type = type,
        url = url,
    )
