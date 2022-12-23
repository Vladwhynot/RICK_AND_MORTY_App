package com.example.rickandmorty.presentation.screens.episodes.episodes_filter_fragment


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.domain.interactors.episodes.episode_filters.GetListEpisodes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EpisodeFiltersViewModel(
    private val getListEpisodes: GetListEpisodes,
) : ViewModel() {
    private val _episodeList = MutableStateFlow<List<String>>(listOf())
    val episodeList: StateFlow<List<String>> = _episodeList


    init {
        viewModelScope.launch {
            getListEpisodes.execute()
                .collect { list ->
                    _episodeList.value = list
                }
        }
    }

}