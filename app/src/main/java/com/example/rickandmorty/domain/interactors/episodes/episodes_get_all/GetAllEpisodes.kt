package com.example.rickandmorty.domain.interactors.episodes.episodes_get_all

import androidx.paging.PagingData
import com.example.rickandmorty.domain.models.episode.EpisodeModel
import com.example.rickandmorty.domain.repositories.episodes.Episodes
import kotlinx.coroutines.flow.Flow

class GetAllEpisodes(
    private val episodes: Episodes
) {

    fun execute(
        name: String?,
        episode: String?
    ): Flow<PagingData<EpisodeModel>> {
        return episodes.getAllEpisodes(
            name = name,
            episode = episode
        )
    }
}