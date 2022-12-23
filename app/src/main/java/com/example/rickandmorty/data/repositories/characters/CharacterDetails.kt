package com.example.rickandmorty.data.repositories.characters

import com.example.rickandmorty.data.mapper.entity_to_domain.CharacterEntityToCharacterModel
import com.example.rickandmorty.data.models.characters.Characters
import com.example.rickandmorty.data.remote.api.chatacters.CharacterDetailsApi
import com.example.rickandmorty.data.storage.room.db.RickAndMortyDatabase
import com.example.rickandmorty.domain.models.character.CharacterModel
import com.example.rickandmorty.domain.repositories.characters.CharacterDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


class CharacterDetails(
    private val characterDetailsApi: CharacterDetailsApi,
    private val db: RickAndMortyDatabase
) : CharacterDetails {

    override suspend fun getCharacterById(id: Int): CharacterModel = withContext(Dispatchers.IO) {

            val characterFromApi: Response<Characters> =
                characterDetailsApi.getCharacterById(id = id)
            if (characterFromApi.isSuccessful) {
                characterFromApi.body()
                    ?.let { db.getCharacterDao().insertCharacter(character = it) }
            }

        return@withContext CharacterEntityToCharacterModel().transform(
            db.getCharacterDao().getCharacterById(id = id)
        )
    }

}