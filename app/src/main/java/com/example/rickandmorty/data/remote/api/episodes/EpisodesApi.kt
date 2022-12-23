package com.example.rickandmorty.data.remote.api.episodes

import com.example.rickandmorty.data.models.PagedResponse
import com.example.rickandmorty.data.models.episodes.Episode
import retrofit2.Response
import retrofit2.http.*

interface EpisodesApi {

    @GET("episode/{ids}")
    suspend fun getEpisodesByIds(
        @Path("ids") ids: String
    ): Response<List<Episode>>

    @GET("episode/")
    suspend fun getEpisodes(
        @Query("page") page: Int,
        @Query("name") name: String?,
        @Query("episode") episode: String?
    ): PagedResponse<Episode>

}