package com.example.rickandmorty.domain.repositories.locations

import kotlinx.coroutines.flow.Flow

interface GetLocationFilters {

    fun getListLocationsTypes(): Flow<List<String>>

    fun getListLocationsDimensions(): Flow<List<String>>
}