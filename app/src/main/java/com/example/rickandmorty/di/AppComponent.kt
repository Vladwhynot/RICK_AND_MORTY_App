package com.example.rickandmorty.di

import androidx.paging.ExperimentalPagingApi
import com.example.rickandmorty.di.module.AppModule
import com.example.rickandmorty.di.module.DataModule
import com.example.rickandmorty.di.module.DomainModule
import com.example.rickandmorty.presentation.screens.characters.character_details_fragment.CharacterDetailsFragment
import com.example.rickandmorty.presentation.screens.characters.characters_fragment.CharactersFragment
import com.example.rickandmorty.presentation.screens.episodes.episode_details_fragment.EpisodeDetailsFragment
import com.example.rickandmorty.presentation.screens.episodes.episodes_filter_fragment.EpisodeFiltersFragment
import com.example.rickandmorty.presentation.screens.episodes.episodes_fragment.EpisodesFragment
import com.example.rickandmorty.presentation.screens.locations.location_details_fragment.LocationDetailsFragment
import com.example.rickandmorty.presentation.screens.locations.locations_fragment.LocationsFragment
import dagger.Component
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@ExperimentalPagingApi

@Singleton
@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {

    fun inject(characterDetailsFragment: CharacterDetailsFragment)
    fun inject(charactersFragment: CharactersFragment)

    fun inject(episodeDetailsFragment: EpisodeDetailsFragment)
    fun inject(episodeFiltersFragment: EpisodeFiltersFragment)
    fun inject(episodesFragment: EpisodesFragment)

    fun inject(locationDetailsFragment: LocationDetailsFragment)
    fun inject(locationsFragment: LocationsFragment)
}