package com.example.rickandmorty.presentation.screens.episodes.episodes_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.ExperimentalPagingApi
import com.example.rickandmorty.domain.interactors.episodes.episodes_get_all.GetAllEpisodes

@ExperimentalPagingApi
class EpisodesViewModelFactory(
    private val getAllEpisodes: GetAllEpisodes
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EpisodesViewModel(
            getAllEpisodes = getAllEpisodes
        ) as T
    }
}