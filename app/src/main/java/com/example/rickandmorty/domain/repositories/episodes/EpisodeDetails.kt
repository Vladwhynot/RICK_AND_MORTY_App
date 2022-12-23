package com.example.rickandmorty.domain.repositories.episodes

import com.example.rickandmorty.domain.models.episode.EpisodeModel

interface EpisodeDetails {

    suspend fun getEpisodeById(id: Int): EpisodeModel
}