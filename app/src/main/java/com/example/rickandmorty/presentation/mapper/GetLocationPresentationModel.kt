package com.example.rickandmorty.presentation.mapper

import com.example.rickandmorty.data.mapper.entity_to_domain.Mapper
import com.example.rickandmorty.domain.models.location.LocationModel
import com.example.rickandmorty.presentation.models.location.LocationPresentation

class GetLocationPresentationModel :
    Mapper<LocationModel, LocationPresentation> {

    override fun transform(data: LocationModel): LocationPresentation {

        return LocationPresentation(
            id = data.id,
            name = data.name,
            type = data.type,
            dimension = data.dimension,
            residentsIds = data.residentsIds
        )
    }
}