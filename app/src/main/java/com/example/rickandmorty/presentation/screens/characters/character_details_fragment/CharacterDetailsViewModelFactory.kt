package com.example.rickandmorty.presentation.screens.characters.character_details_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.ExperimentalPagingApi
import com.example.rickandmorty.domain.interactors.characters.character_details.GetCharacterById
import com.example.rickandmorty.domain.interactors.episodes.episodes_get_all.GetAllEpisodesByIds


@ExperimentalPagingApi
class CharacterDetailsViewModelFactory(
    private val getCharacterById: GetCharacterById,
    private val getAllEpisodesByIds: GetAllEpisodesByIds
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CharacterDetailsViewModel(
            getCharacterById = getCharacterById,
            getAllEpisodesByIds = getAllEpisodesByIds
        ) as T
    }
}