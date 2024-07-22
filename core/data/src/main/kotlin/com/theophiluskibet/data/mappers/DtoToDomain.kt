package com.theophiluskibet.data.mappers

import com.theophiluskibet.domain.models.CharactersDomainModel
import com.theophiluskibet.remote.model.CharacterDto

fun CharacterDto.toDomain() =
    CharactersDomainModel(
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
