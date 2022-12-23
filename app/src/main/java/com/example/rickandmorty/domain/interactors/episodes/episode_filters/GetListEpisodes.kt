package com.example.rickandmorty.domain.interactors.episodes.episode_filters

import com.example.rickandmorty.domain.repositories.episodes.GetEpisodeFilters
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetListEpisodes(
    private val getEpisodeFilters: GetEpisodeFilters
) {

    fun execute(): Flow<List<String>> =
        getEpisodeFilters.getListEpisodes().map { it.distinct() }
}