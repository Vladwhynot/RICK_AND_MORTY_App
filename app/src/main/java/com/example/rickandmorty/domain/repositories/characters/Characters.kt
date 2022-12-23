package com.example.rickandmorty.domain.repositories.characters
import androidx.paging.PagingData
import com.example.rickandmorty.domain.models.character.CharacterModel
import kotlinx.coroutines.flow.Flow

interface Characters {

    fun getAllCharacters(
        name: String?,
        status: String?,
        gender: String?,
        type: String?,
        species: String?
    ): Flow<PagingData<CharacterModel>>

    suspend fun getAllCharactersByIds(ids: List<Int>): List<CharacterModel>

}