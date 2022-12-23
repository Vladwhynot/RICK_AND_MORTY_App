package com.example.rickandmorty.domain.interactors.locations.locations

import androidx.paging.PagingData
import com.example.rickandmorty.domain.models.location.LocationModel
import com.example.rickandmorty.domain.repositories.locations.Locations
import kotlinx.coroutines.flow.Flow

class GetAllLocations(
    private val locations: Locations
) {

    fun execute(
        name: String?,
        type: String?,
        dimension: String?
    ): Flow<PagingData<LocationModel>> {
        return locations.getAllLocations(
            name = name,
            type = type,
            dimension = dimension
        )
    }
}