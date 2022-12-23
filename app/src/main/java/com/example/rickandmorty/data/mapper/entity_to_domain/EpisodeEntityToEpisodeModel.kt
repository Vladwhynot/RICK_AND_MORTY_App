package com.example.rickandmorty.data.mapper.entity_to_domain

import com.example.rickandmorty.data.models.episodes.Episode
import com.example.rickandmorty.domain.models.episode.EpisodeModel

class EpisodeEntityToEpisodeModel :
    Mapper<Episode, EpisodeModel> {

    override fun transform(data: Episode): EpisodeModel {

        val residentsIds: List<Int> = data.characters.mapNotNull { residents ->
            residents.dropWhile { char ->
                !char.isDigit()
            }.toIntOrNull()
        }

        return EpisodeModel(
            id = data.id,
            name = data.name,
            episode = data.episode,
            air_date = data.air_date,
            residentsIds = residentsIds
        )
    }
}