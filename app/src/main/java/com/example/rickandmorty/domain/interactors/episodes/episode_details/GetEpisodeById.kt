package com.example.rickandmorty.domain.interactors.episodes.episode_details

import com.example.rickandmorty.domain.models.episode.EpisodeModel
import com.example.rickandmorty.domain.repositories.episodes.EpisodeDetails

class GetEpisodeById(
    private val episodeDetails: EpisodeDetails
) {

    suspend fun execute(id: Int): EpisodeModel =
        episodeDetails.getEpisodeById(id = id)
}