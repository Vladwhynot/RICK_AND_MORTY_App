package com.example.rickandmorty.presentation.screens.locations.locations_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.ExperimentalPagingApi
import com.example.rickandmorty.domain.interactors.locations.locations.GetAllLocations

@ExperimentalPagingApi
class LocationsViewModelFactory(
    private val getAllLocations: GetAllLocations
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LocationsViewModel(
            getAllLocations = getAllLocations
        ) as T
    }
}