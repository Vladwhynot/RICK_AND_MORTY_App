package com.example.rickandmorty.presentation.screens.episodes.episode_details_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.ExperimentalPagingApi
import com.example.rickandmorty.domain.interactors.characters.characters_get_all.GetAllCharactersByIds
import com.example.rickandmorty.domain.interactors.episodes.episode_details.GetEpisodeById


@ExperimentalPagingApi
class EpisodeDetailsViewModelFactory(
    private val getEpisodeById: GetEpisodeById,
    private val getAllCharactersByIds: GetAllCharactersByIds
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EpisodeDetailsViewModel(
            getEpisodeById = getEpisodeById,
            getAllCharactersByIds = getAllCharactersByIds
        ) as T
    }
}