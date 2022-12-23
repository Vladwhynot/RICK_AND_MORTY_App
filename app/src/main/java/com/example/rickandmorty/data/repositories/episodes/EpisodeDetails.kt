package com.example.rickandmorty.data.repositories.episodes

import com.example.rickandmorty.data.mapper.entity_to_domain.EpisodeEntityToEpisodeModel
import com.example.rickandmorty.data.models.episodes.Episode
import com.example.rickandmorty.data.remote.api.episodes.EpisodeDetailsApi
import com.example.rickandmorty.data.storage.room.db.RickAndMortyDatabase
import com.example.rickandmorty.domain.models.episode.EpisodeModel
import com.example.rickandmorty.domain.repositories.episodes.EpisodeDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


class EpisodeDetails(
    private val episodeDetailsApi: EpisodeDetailsApi,
    private val db: RickAndMortyDatabase
) : EpisodeDetails {

    override suspend fun getEpisodeById(id: Int): EpisodeModel = withContext(Dispatchers.IO) {

            val episodeFromApi: Response<Episode> =
                episodeDetailsApi.getEpisodeById(id = id)
            if (episodeFromApi.isSuccessful) {
                episodeFromApi.body()
                    ?.let { db.getEpisodeDao().insertEpisode(episode = it) }
            }

        return@withContext EpisodeEntityToEpisodeModel().transform(
            db.getEpisodeDao().getEpisodeById(id = id)
        )
    }
}