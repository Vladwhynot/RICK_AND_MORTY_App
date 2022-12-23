package com.example.rickandmorty.domain.repositories.characters

import com.example.rickandmorty.domain.models.character.CharacterModel

interface CharacterDetails {

    suspend fun getCharacterById(id: Int): CharacterModel
}