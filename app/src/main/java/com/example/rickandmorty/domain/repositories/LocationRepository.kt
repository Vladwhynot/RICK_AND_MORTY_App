package com.example.rickandmorty.domain.repositories

interface LocationRepository {
    suspend fun saveLocationSettings(types: Map<String, List<String>>)

    suspend fun getLocationSettings(): Map<String, List<String>>

}