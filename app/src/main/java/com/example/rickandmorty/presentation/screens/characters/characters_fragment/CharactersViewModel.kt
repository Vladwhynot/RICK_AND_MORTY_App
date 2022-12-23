package com.example.rickandmorty.presentation.screens.characters.characters_fragment

import androidx.lifecycle.*
import androidx.paging.*
import com.example.rickandmorty.domain.interactors.characters.characters_get_all.GetAllCharacters
import com.example.rickandmorty.presentation.mapper.GetCharacterPresentationModel
import com.example.rickandmorty.presentation.models.character.CharacterPresentation
import kotlinx.coroutines.flow.*


@ExperimentalPagingApi
class CharactersViewModel(
    private val getAllCharacters: GetAllCharacters,
) : ViewModel() {

    private val _filteredTrigger = MutableStateFlow<MutableMap<String, String?>>(
        mutableMapOf(
            "name" to null,
            "gender" to null,
            "status" to null,
            "species" to null,
            "type" to null
        )
    )
    val filteredTrigger: MutableStateFlow<MutableMap<String, String?>> = _filteredTrigger

    private var _charactersFlow = MutableSharedFlow<PagingData<CharacterPresentation>>()
    val charactersFlow = _charactersFlow



    fun getCharactersByParams(
        name: String?,
        status: String?,
        gender: String?,
        type: String?,
        species: String?
    ) {
        getAllCharacters.execute(
            name = name,
            status = status,
            gender = gender,
            type = type,
            species = species
        ).onEach {
            _charactersFlow.emit(
                it.map { obj -> GetCharacterPresentationModel().transform(obj) }
            )
        }.launchIn(viewModelScope)
    }
}
