package com.example.rickandmorty.presentation.screens.episodes.episodes_fragment

import androidx.lifecycle.*
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import androidx.paging.map

import com.example.rickandmorty.domain.interactors.episodes.episodes_get_all.GetAllEpisodes
import com.example.rickandmorty.presentation.mapper.GetEpisodePresentationModel
import com.example.rickandmorty.presentation.models.episode.EpisodePresentation
import kotlinx.coroutines.flow.*


@ExperimentalPagingApi
class EpisodesViewModel(
    private val getAllEpisodes: GetAllEpisodes
) : ViewModel() {


    private val _filteredTrigger = MutableStateFlow<MutableMap<String, String?>>(
        mutableMapOf(
            "name" to null,
            "episode" to null
        )
    )

    val filteredTrigger: MutableStateFlow<MutableMap<String, String?>> = _filteredTrigger

    private var _episodesFlow = MutableSharedFlow<PagingData<EpisodePresentation>>()
    val episodesFlow = _episodesFlow

    fun getEpisodeByParams(
        name: String?,
        episode: String?
    ) {
        getAllEpisodes.execute(
            name = name,
            episode = episode
        ).onEach {
            _episodesFlow.emit(
                it.map { obj -> GetEpisodePresentationModel().transform(obj) }
            )
        }.launchIn(viewModelScope)

    }
}