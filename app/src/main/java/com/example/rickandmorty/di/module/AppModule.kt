package com.example.rickandmorty.di.module

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import com.example.rickandmorty.domain.interactors.characters.character_details.GetCharacterById
import com.example.rickandmorty.domain.interactors.characters.characters_get_all.GetAllCharactersByIds
import com.example.rickandmorty.domain.interactors.characters.characters_get_all.GetAllCharacters
import com.example.rickandmorty.domain.interactors.episodes.episode_details.GetEpisodeById
import com.example.rickandmorty.domain.interactors.episodes.episode_filters.GetListEpisodes
import com.example.rickandmorty.domain.interactors.episodes.episodes_get_all.GetAllEpisodesByIds
import com.example.rickandmorty.domain.interactors.episodes.episodes_get_all.GetAllEpisodes
import com.example.rickandmorty.domain.interactors.locations.location_details.GetLocationById
import com.example.rickandmorty.domain.interactors.locations.locations.GetAllLocations
import com.example.rickandmorty.presentation.screens.characters.character_details_fragment.CharacterDetailsViewModelFactory
import com.example.rickandmorty.presentation.screens.characters.characters_fragment.CharactersViewModelFactory
import com.example.rickandmorty.presentation.screens.episodes.episode_details_fragment.EpisodeDetailsViewModelFactory
import com.example.rickandmorty.presentation.screens.episodes.episodes_filter_fragment.EpisodeFilterViewModelFactory
import com.example.rickandmorty.presentation.screens.episodes.episodes_fragment.EpisodesViewModelFactory
import com.example.rickandmorty.presentation.screens.locations.location_details_fragment.LocationDetailsViewModelFactory
import com.example.rickandmorty.presentation.screens.locations.locations_fragment.LocationsViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@ExperimentalPagingApi
@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context{
        return context
    }


    @Provides
    @Singleton
    fun provideLocationsViewModelProvider(getAllLocations: GetAllLocations): LocationsViewModelFactory {
        return LocationsViewModelFactory(
            getAllLocations = getAllLocations
        )
    }



    @Provides
    @Singleton
    fun provideLocationDetailsViewModelProvider(getLocationById: GetLocationById, getAllCharactersByIds: GetAllCharactersByIds): LocationDetailsViewModelFactory {
        return LocationDetailsViewModelFactory(
            getLocationById = getLocationById,
            getAllCharactersByIds = getAllCharactersByIds
        )
    }


    @Provides
    @Singleton
    fun provideEpisodesViewModelProvider(getAllEpisodes: GetAllEpisodes, ): EpisodesViewModelFactory {
        return EpisodesViewModelFactory(
            getAllEpisodes = getAllEpisodes,
        )
    }


    @Provides
    @Singleton
    fun provideEpisodeFilterViewModelProvider(getListEpisodes: GetListEpisodes, ): EpisodeFilterViewModelFactory {
        return EpisodeFilterViewModelFactory(
            getListEpisodes = getListEpisodes,
        )
    }


    @Provides
    @Singleton
    fun provideEpisodeDetailsViewModelProvider(getEpisodeById: GetEpisodeById, getAllCharactersByIds: GetAllCharactersByIds): EpisodeDetailsViewModelFactory {
        return EpisodeDetailsViewModelFactory(
            getEpisodeById = getEpisodeById,
            getAllCharactersByIds = getAllCharactersByIds
        )
    }

    @Provides
    @Singleton
    fun provideCharactersViewModelProvider(getAllCharacters: GetAllCharacters): CharactersViewModelFactory {
        return CharactersViewModelFactory(
            getAllCharacters = getAllCharacters
        )
    }


    @Provides
    @Singleton
    fun provideCharacterDetailsViewModelProvider(getCharacterById: GetCharacterById, getAllEpisodesByIds: GetAllEpisodesByIds): CharacterDetailsViewModelFactory {
        return CharacterDetailsViewModelFactory(
            getCharacterById = getCharacterById,
            getAllEpisodesByIds = getAllEpisodesByIds
        )
    }

}