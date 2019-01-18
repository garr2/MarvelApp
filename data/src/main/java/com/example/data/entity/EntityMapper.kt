package com.example.data.entity

import com.example.domain.entity.Characters

private const val PORTRAIT_ASPECT_RATIO = "/portrait_medium."

fun CharactersResponse.Characters.transformToCharacter(): Characters {
    return Characters(
        id = id, name = name, description = description, photoUrl = thumbnail?.photoUrl
        + PORTRAIT_ASPECT_RATIO + thumbnail?.extension
    )
}