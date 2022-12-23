package com.example.rickandmorty.domain.repositories.locations

import com.example.rickandmorty.domain.models.location.LocationModel

interface LocationDetails {

    suspend fun getLocationById(id: Int): LocationModel
}