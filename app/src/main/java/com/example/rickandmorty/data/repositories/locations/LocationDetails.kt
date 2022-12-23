package com.example.rickandmorty.data.repositories.locations

import com.example.rickandmorty.data.mapper.entity_to_domain.LocationEntityToLocationModel
import com.example.rickandmorty.data.models.location.Location
import com.example.rickandmorty.data.remote.api.locations.LocationDetailsApi
import com.example.rickandmorty.data.storage.room.db.RickAndMortyDatabase
import com.example.rickandmorty.domain.models.location.LocationModel
import com.example.rickandmorty.domain.repositories.locations.LocationDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


class LocationDetails(
    private val locationDetailsApi: LocationDetailsApi,
    private val db: RickAndMortyDatabase
) : LocationDetails {

    override suspend fun getLocationById(id: Int): LocationModel = withContext(Dispatchers.IO) {

            val locationFromApi: Response<Location> =
                locationDetailsApi.getLocationById(id = id)
            if (locationFromApi.isSuccessful) {
                locationFromApi.body()
                    ?.let { db.getLocationDao().insertLocation(location = it) }
            }

        return@withContext LocationEntityToLocationModel().transform(
            db.getLocationDao().getLocationById(id = id)
        )
    }
}