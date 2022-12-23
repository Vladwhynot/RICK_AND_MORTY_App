package com.example.rickandmorty.data.repositories.episodes

import com.example.rickandmorty.data.storage.room.db.RickAndMortyDatabase
import com.example.rickandmorty.domain.repositories.episodes.GetEpisodeFilters
import kotlinx.coroutines.flow.Flow

class GetEpisodeFiltersImpl(
    private val db: RickAndMortyDatabase
) : GetEpisodeFilters {

    override fun getListEpisodes(): Flow<List<String>> =
        db.getEpisodeDao().getEpisodes()
}