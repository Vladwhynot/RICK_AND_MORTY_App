package com.example.rickandmorty.data.repositories.locations

import androidx.paging.*
import com.example.rickandmorty.data.mapper.entity_to_domain.LocationEntityToLocationModel
import com.example.rickandmorty.data.paging.LocationsRemoteMediator
import com.example.rickandmorty.data.remote.api.locations.LocationsApi
import com.example.rickandmorty.data.storage.room.db.RickAndMortyDatabase
import com.example.rickandmorty.domain.models.location.LocationModel
import com.example.rickandmorty.domain.repositories.locations.Locations
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


@ExperimentalPagingApi
class LocationsImpl(
    private val locationsApi: LocationsApi,
    private val db: RickAndMortyDatabase
) : Locations {

    override fun getAllLocations(
        name: String?,
        type: String?,
        dimension: String?
    ): Flow<PagingData<LocationModel>> {

        val pagingSourceFactory =
            {
                db.getLocationDao().getFilteredLocations(
                    name = name,
                    type = type,
                    dimension = dimension
                )
            }

        return Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 2,
                maxSize = PagingConfig.MAX_SIZE_UNBOUNDED,
                jumpThreshold = Int.MIN_VALUE,
                enablePlaceholders = true,
            ),
            remoteMediator = LocationsRemoteMediator(
                locationsApi = locationsApi,
                db = db,
                name = name,
                type = type,
                dimension = dimension
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow.map { pagingData ->
            pagingData.map { it ->
                LocationEntityToLocationModel().transform(it)
            }
        }
    }

    override suspend fun getAllLocationsByIds(ids: List<Int>): List<LocationModel> {
        TODO("Not yet implemented")
    }
}