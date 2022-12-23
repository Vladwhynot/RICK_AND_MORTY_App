package com.example.rickandmorty.data.remote.api.chatacters

import com.example.rickandmorty.data.models.characters.Characters
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterDetailsApi {

    @GET("character/{id}")
    suspend fun getCharacterById(
        @Path("id") id: Int
    ): Response<Characters>

}