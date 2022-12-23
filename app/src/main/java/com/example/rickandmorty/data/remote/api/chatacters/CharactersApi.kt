package com.example.rickandmorty.data.remote.api.chatacters

import com.example.rickandmorty.data.models.characters.Characters
import com.example.rickandmorty.data.models.PagedResponse
import retrofit2.Response
import retrofit2.http.*

interface CharactersApi {

    @GET("character/{ids}")
    suspend fun getCharactersByIds(
        @Path("ids") ids: String
    ): Response<List<Characters>>

    @GET("character/")
    suspend fun getCharacters(
        @Query("page") page: Int,
        @Query("name") name: String?,
        @Query("status") status: String?,
        @Query("species") species: String?,
        @Query("type") type: String?,
        @Query("gender") gender: String?
    ): PagedResponse<Characters>

}