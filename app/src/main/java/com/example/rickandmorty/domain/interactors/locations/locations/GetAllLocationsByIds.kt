package com.example.rickandmorty.domain.interactors.locations.locations

import com.example.rickandmorty.domain.models.location.LocationModel
import com.example.rickandmorty.domain.repositories.locations.Locations

class GetAllLocationsByIds(
    private val locations: Locations
) {

    suspend fun execute(
        ids: List<Int>
    ): List<LocationModel> {
        return locations.getAllLocationsByIds(
            ids = ids
        )
    }
}