package com.example.rickandmorty.presentation.screens.locations.location_details_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.domain.interactors.characters.characters_get_all.GetAllCharactersByIds
import com.example.rickandmorty.domain.interactors.locations.location_details.GetLocationById
import com.example.rickandmorty.presentation.mapper.GetCharacterPresentationModel
import com.example.rickandmorty.presentation.mapper.GetLocationPresentationModel
import com.example.rickandmorty.presentation.models.character.CharacterPresentation
import com.example.rickandmorty.presentation.models.location.LocationPresentation
import kotlinx.coroutines.launch

class LocationDetailsViewModel(
    private val getLocationById: GetLocationById,
    private val getAllCharactersByIds: GetAllCharactersByIds
) : ViewModel() {

    private val _locationDetails = MutableLiveData<LocationPresentation>()
    val locationDetails: MutableLiveData<LocationPresentation> = _locationDetails

    private val _charactersList = MutableLiveData<List<CharacterPresentation>>()
    val charactersList: MutableLiveData<List<CharacterPresentation>> = _charactersList

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = _isLoading

    fun getLocation(id: Int) {
        viewModelScope.launch {
            _locationDetails.value =
                GetLocationPresentationModel().transform(getLocationById.execute(id = id))
        }
    }

    fun getEpisodesList(ids: List<Int>) {
        viewModelScope.launch() {
            kotlin.runCatching {
            }.onSuccess { it ->
                _isLoading.postValue(false)
                _charactersList.value =
                    getAllCharactersByIds.execute(ids = ids).map {
                        GetCharacterPresentationModel().transform(it)
                    }
            }.onFailure {
                _isLoading.postValue(false)
            }
        }
    }
}