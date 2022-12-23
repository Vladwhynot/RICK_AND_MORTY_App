package com.example.rickandmorty.di.module

import com.example.rickandmorty.domain.repositories.characters.CharacterDetails
import com.example.rickandmorty.domain.repositories.characters.Characters
import com.example.rickandmorty.domain.repositories.episodes.EpisodeDetails
import com.example.rickandmorty.domain.repositories.episodes.Episodes
import com.example.rickandmorty.domain.repositories.episodes.GetEpisodeFilters
import com.example.rickandmorty.domain.repositories.locations.GetLocationFilters
import com.example.rickandmorty.domain.repositories.locations.LocationDetails
import com.example.rickandmorty.domain.repositories.locations.Locations
import com.example.rickandmorty.domain.interactors.characters.character_details.GetCharacterById
import com.example.rickandmorty.domain.interactors.characters.characters_get_all.GetAllCharactersByIds
import com.example.rickandmorty.domain.interactors.characters.characters_get_all.GetAllCharacters
import com.example.rickandmorty.domain.interactors.episodes.episode_details.GetEpisodeById
import com.example.rickandmorty.domain.interactors.episodes.episode_filters.GetListEpisodes
import com.example.rickandmorty.domain.interactors.episodes.episodes_get_all.GetAllEpisodesByIds
import com.example.rickandmorty.domain.interactors.episodes.episodes_get_all.GetAllEpisodes
import com.example.rickandmorty.domain.interactors.locations.location_details.GetLocationById
import com.example.rickandmorty.domain.interactors.locations.locations.GetAllLocationsByIds
import com.example.rickandmorty.domain.interactors.locations.locations.GetAllLocations
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Provides
    @Singleton
    fun provideGetAllLocationsUseCase(locations: Locations): GetAllLocations {
        return GetAllLocations(
            locations = locations
        )
    }


    @Provides
    @Singleton
    fun provideGetAllLocationsByIdsUseCase(locations: Locations): GetAllLocationsByIds {
        return GetAllLocationsByIds(
            locations = locations
        )
    }



    @Provides
    @Singleton
    fun provideGetLocationByIdUseCase(locationDetails: LocationDetails): GetLocationById {
        return GetLocationById(
            locationDetails = locationDetails
        )
    }


    @Provides
    @Singleton
    fun provideGetAllEpisodesUseCase(episodes: Episodes): GetAllEpisodes {
        return GetAllEpisodes(
            episodes = episodes
        )
    }


    @Provides
    @Singleton
    fun provideGetAllEpisodesByIdsUseCase(episodes: Episodes): GetAllEpisodesByIds {
        return GetAllEpisodesByIds(
            episodes = episodes
        )
    }


    @Provides
    @Singleton
    fun provideGetListEpisodesUseCase(getEpisodeFilters: GetEpisodeFilters): GetListEpisodes {
        return GetListEpisodes(
            getEpisodeFilters = getEpisodeFilters
        )
    }



    @Provides
    @Singleton
    fun provideGetEpisodeByIdUseCase(episodeDetails: EpisodeDetails): GetEpisodeById {
        return GetEpisodeById(
            episodeDetails = episodeDetails
        )
    }



    @Provides
    @Singleton
    fun provideGetAllCharactersUseCase(characters: Characters): GetAllCharacters {
        return GetAllCharacters(
            characters = characters
        )
    }



    @Provides
    @Singleton
    fun provideGetAllCharactersByIdsUseCase(characters: Characters): GetAllCharactersByIds {
        return GetAllCharactersByIds(
            characters = characters
        )
    }



    @Provides
    @Singleton
    fun provideGetCharacterByIdUseCase(characterDetails: CharacterDetails): GetCharacterById {
        return GetCharacterById(
            characterDetails = characterDetails
        )
    }

}