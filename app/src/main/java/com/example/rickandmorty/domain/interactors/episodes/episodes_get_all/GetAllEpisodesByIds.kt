package com.example.rickandmorty.domain.interactors.episodes.episodes_get_all

import com.example.rickandmorty.domain.models.episode.EpisodeModel
import com.example.rickandmorty.domain.repositories.episodes.Episodes

class GetAllEpisodesByIds(
    private val episodes: Episodes
) {

    suspend fun execute(
        ids: List<Int>
    ): List<EpisodeModel> {
        return episodes.getAllEpisodesByIds(ids = ids)
    }
}