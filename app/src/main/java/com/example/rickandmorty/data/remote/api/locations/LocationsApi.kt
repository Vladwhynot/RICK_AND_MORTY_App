package com.example.rickandmorty.data.remote.api.locations

import com.example.rickandmorty.data.models.PagedResponse
import com.example.rickandmorty.data.models.location.Location
import retrofit2.Response
import retrofit2.http.*

interface LocationsApi {

    @GET("location/{ids}")
    suspend fun getLocationsByIds(
        @Path("ids") ids: String
    ): Response<List<Location>>

    @GET("location/")
    suspend fun getLocations(
        @Query("page") page: Int,
        @Query("name") name: String?,
        @Query("type") type: String?,
        @Query("dimension") dimension: String?
    ): PagedResponse<Location>

}