package com.example.rickandmorty.presentation.screens.episodes.episodes_filter_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmorty.domain.interactors.episodes.episode_filters.GetListEpisodes


class EpisodeFilterViewModelFactory(
    private val getListEpisodes: GetListEpisodes
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EpisodeFiltersViewModel(
            getListEpisodes = getListEpisodes,
        ) as T
    }
}