package com.example.rickandmorty.data.remote.api.locations

import com.example.rickandmorty.data.models.location.Location
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LocationDetailsApi {

    @GET("location/{id}")
    suspend fun getLocationById(
        @Path("id") id: Int
    ): Response<Location>
}