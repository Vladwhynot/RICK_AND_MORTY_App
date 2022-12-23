package com.example.rickandmorty.domain.repositories.episodes

import kotlinx.coroutines.flow.Flow

interface GetEpisodeFilters {

    fun getListEpisodes(): Flow<List<String>>
}