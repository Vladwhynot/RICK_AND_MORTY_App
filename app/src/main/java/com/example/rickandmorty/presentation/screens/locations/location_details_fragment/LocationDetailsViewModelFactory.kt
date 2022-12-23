package com.example.rickandmorty.presentation.screens.locations.location_details_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.ExperimentalPagingApi
import com.example.rickandmorty.domain.interactors.characters.characters_get_all.GetAllCharactersByIds
import com.example.rickandmorty.domain.interactors.locations.location_details.GetLocationById

@ExperimentalPagingApi
class LocationDetailsViewModelFactory(
    private val getLocationById: GetLocationById,
    private val getAllCharactersByIds: GetAllCharactersByIds
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LocationDetailsViewModel(
            getLocationById = getLocationById,
            getAllCharactersByIds = getAllCharactersByIds
        ) as T
    }
}