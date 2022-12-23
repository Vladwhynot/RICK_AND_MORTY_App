package com.example.rickandmorty.domain.interactors.characters.character_details

import com.example.rickandmorty.domain.models.character.CharacterModel
import com.example.rickandmorty.domain.repositories.characters.CharacterDetails

class GetCharacterById(
    private val characterDetails: CharacterDetails
) {

    suspend fun execute(id: Int): CharacterModel =
        characterDetails.getCharacterById(id = id)
}