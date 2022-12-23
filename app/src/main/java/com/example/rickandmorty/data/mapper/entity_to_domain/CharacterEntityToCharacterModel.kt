package com.example.rickandmorty.data.mapper.entity_to_domain

import com.example.rickandmorty.data.models.characters.Characters
import com.example.rickandmorty.domain.models.character.CharacterModel

private const val locationName =  "location_name"
private const val locationId  =  "location_id"

class CharacterEntityToCharacterModel :
    Mapper<Characters, CharacterModel> {

    override fun transform(data: Characters): CharacterModel {

        val originLocation: Map<String, String> = mapOf(
            Pair(locationName, data.origin.name),
            Pair(locationId, data.origin.url.substringAfterLast("/")))

        val lastLocation: Map<String, String> = mapOf(
            Pair(locationName, data.location.name),
            Pair(locationId, data.location.url.substringAfterLast("/")))

        val episodeIds: List<Int> = data.episode.mapNotNull { episodeUrl ->
            episodeUrl.dropWhile { char ->
                !char.isDigit()
            }.toIntOrNull()
        }

        return CharacterModel(
            id = data.id,
            name = data.name,
            species = data.species,
            status = data.status,
            type = data.type,
            gender = data.gender,
            originLocation = originLocation,
            lastLocation = lastLocation,
            imageUrl = data.image,
            episodeIds = episodeIds
        )
    }
}