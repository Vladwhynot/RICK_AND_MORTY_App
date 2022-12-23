package com.example.rickandmorty.domain.interactors.characters.characters_get_all

import androidx.paging.PagingData
import com.example.rickandmorty.domain.models.character.CharacterModel
import com.example.rickandmorty.domain.repositories.characters.Characters
import kotlinx.coroutines.flow.Flow

class GetAllCharacters(
    private val characters: Characters
) {

    fun execute(
        name: String?,
        status: String?,
        gender: String?,
        type: String?,
        species: String?
    ): Flow<PagingData<CharacterModel>> {
        return characters.getAllCharacters(
            name = name,
            status = status,
            gender = gender,
            type = type,
            species = species
        )
    }
}