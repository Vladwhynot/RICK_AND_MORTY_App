package com.example.rickandmorty.domain.interactors.locations.location_details

import com.example.rickandmorty.domain.models.location.LocationModel
import com.example.rickandmorty.domain.repositories.locations.LocationDetails

class GetLocationById(
    private val locationDetails: LocationDetails
) {

    suspend fun execute(id: Int): LocationModel =
        locationDetails.getLocationById(id = id)
}