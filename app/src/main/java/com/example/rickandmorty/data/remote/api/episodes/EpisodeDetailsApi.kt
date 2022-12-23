package com.example.rickandmorty.data.remote.api.episodes

import com.example.rickandmorty.data.models.episodes.Episode
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EpisodeDetailsApi {

    @GET("episode/{id}")
    suspend fun getEpisodeById(
        @Path("id") id: Int
    ): Response<Episode>

}