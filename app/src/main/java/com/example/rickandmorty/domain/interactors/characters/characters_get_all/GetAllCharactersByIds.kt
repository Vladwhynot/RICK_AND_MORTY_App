package com.example.rickandmorty.domain.interactors.characters.characters_get_all

import com.example.rickandmorty.domain.models.character.CharacterModel
import com.example.rickandmorty.domain.repositories.characters.Characters

class GetAllCharactersByIds(
    private val characters: Characters
) {

    suspend fun execute(
        ids: List<Int>
    ): List<CharacterModel> {
        return characters.getAllCharactersByIds(
            ids = ids
        )
    }
}