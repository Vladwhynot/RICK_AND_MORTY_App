package com.example.rickandmorty.data.mapper.entity_to_domain

import com.example.rickandmorty.data.models.location.Location
import com.example.rickandmorty.domain.models.location.LocationModel

class LocationEntityToLocationModel : Mapper<Location, LocationModel> {

    override fun transform(data: Location): LocationModel {

        val residentsIds: List<Int> = data.residents.mapNotNull { residents ->
            residents.dropWhile { char ->
                !char.isDigit()
            }.toIntOrNull()
        }
        return LocationModel(
            id = data.id,
            name = data.name,
            type = data.type,
            dimension = data.dimension,
            residentsIds = residentsIds
        )
    }
}