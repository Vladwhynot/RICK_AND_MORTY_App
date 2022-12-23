package com.example.rickandmorty.domain.repositories

interface EpisodeRepository {

    suspend fun saveEpisodes(episodes: Map<String, List<String>>)

    suspend fun getEpisodes(): Map<String, List<String>>
}