package com.example.rickandmorty.di.module


import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.room.Room
import com.example.rickandmorty.data.remote.api.chatacters.CharacterDetailsApi
import com.example.rickandmorty.data.remote.api.chatacters.CharactersApi
import com.example.rickandmorty.data.remote.api.episodes.EpisodeDetailsApi
import com.example.rickandmorty.data.remote.api.episodes.EpisodesApi
import com.example.rickandmorty.data.remote.api.locations.LocationDetailsApi
import com.example.rickandmorty.data.remote.api.locations.LocationsApi
import com.example.rickandmorty.data.repositories.episodes.EpisodesImpl
import com.example.rickandmorty.data.repositories.episodes.GetEpisodeFiltersImpl
import com.example.rickandmorty.data.repositories.locations.LocationsImpl
import com.example.rickandmorty.data.storage.room.db.RickAndMortyDatabase
import com.example.rickandmorty.domain.repositories.characters.Characters
import com.example.rickandmorty.domain.repositories.episodes.Episodes
import com.example.rickandmorty.domain.repositories.episodes.GetEpisodeFilters
import com.example.rickandmorty.domain.repositories.locations.Locations
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@ExperimentalPagingApi
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideLocationsRepository(locationsApi: LocationsApi, db: RickAndMortyDatabase): Locations {
        return LocationsImpl(
            locationsApi = locationsApi,
            db = db
        )
    }

    @Provides
    @Singleton
    fun provideLocationDetailsRepository(locationDetailsApi: LocationDetailsApi, db: RickAndMortyDatabase): com.example.rickandmorty.domain.repositories.locations.LocationDetails {
        return com.example.rickandmorty.data.repositories.locations.LocationDetails(
            locationDetailsApi = locationDetailsApi,
            db = db
        )
    }

    @Provides
    @Singleton
    fun provideGetEpisodeFiltersRepository(db: RickAndMortyDatabase): GetEpisodeFilters {
        return GetEpisodeFiltersImpl(
            db = db
        )
    }

    @Provides
    @Singleton
    fun provideEpisodesRepository(db: RickAndMortyDatabase, episodesApi: EpisodesApi, episodeDetailsApi: EpisodeDetailsApi): Episodes {
        return EpisodesImpl(
            episodesApi = episodesApi,
            episodeDetailsApi = episodeDetailsApi,
            db = db
        )
    }

    @Provides
    @Singleton
    fun provideEpisodeDetailsRepository(db: RickAndMortyDatabase, episodeDetailsApi: EpisodeDetailsApi): com.example.rickandmorty.domain.repositories.episodes.EpisodeDetails {
        return com.example.rickandmorty.data.repositories.episodes.EpisodeDetails(
            episodeDetailsApi = episodeDetailsApi,
            db = db
        )
    }



    @Provides
    @Singleton
    fun provideCharactersRepository(db: RickAndMortyDatabase, characterDetailsApi: CharacterDetailsApi, charactersApi: CharactersApi, ): Characters {
        return com.example.rickandmorty.data.repositories.characters.CharactersImpl(
            characterDetailsApi = characterDetailsApi,
            charactersApi = charactersApi,
            db = db
        )
    }


    @Provides
    @Singleton
    fun provideCharacterDetailsRepository(db: RickAndMortyDatabase, characterDetailsApi: CharacterDetailsApi): com.example.rickandmorty.domain.repositories.characters.CharacterDetails {
        return com.example.rickandmorty.data.repositories.characters.CharacterDetails(
            characterDetailsApi = characterDetailsApi,
            db = db
        )
    }

    @Provides
    @Singleton
    fun provideRickAndMortyDatabase(context: Context): RickAndMortyDatabase {
        return Room.databaseBuilder(
            context,
            RickAndMortyDatabase::class.java,
            "RickAndMortyDB.bd"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCharacterDetailsApi(): CharacterDetailsApi {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CharacterDetailsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCharactersApi(): CharactersApi {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CharactersApi::class.java)
    }

    @Provides
    @Singleton
    fun provideEpisodeDetailsApi(): EpisodeDetailsApi {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EpisodeDetailsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideEpisodesApi(): EpisodesApi {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EpisodesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideLocationDetailsApi(): LocationDetailsApi {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LocationDetailsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideLocationsApi(): LocationsApi {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LocationsApi::class.java)
    }
}