package com.example.rickandmorty.presentation.screens.characters.character_details_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.domain.interactors.characters.character_details.GetCharacterById
import com.example.rickandmorty.domain.interactors.episodes.episodes_get_all.GetAllEpisodesByIds
import com.example.rickandmorty.presentation.mapper.GetCharacterPresentationModel
import com.example.rickandmorty.presentation.mapper.GetEpisodePresentationModel
import com.example.rickandmorty.presentation.models.character.CharacterPresentation
import com.example.rickandmorty.presentation.models.episode.EpisodePresentation
import kotlinx.coroutines.launch

class CharacterDetailsViewModel(
    private val getCharacterById: GetCharacterById,
    private val getAllEpisodesByIds: GetAllEpisodesByIds
) : ViewModel() {

    private val _characterDetails = MutableLiveData<CharacterPresentation>()
    val characterDetails: MutableLiveData<CharacterPresentation> = _characterDetails

    private val _episodesList = MutableLiveData<List<EpisodePresentation>>()
    val episodesList: MutableLiveData<List<EpisodePresentation>> = _episodesList

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = _isLoading

    fun getCharacter(id: Int) {
        viewModelScope.launch {
            _characterDetails.value =
                GetCharacterPresentationModel().transform(getCharacterById.execute(id = id))
        }
    }

    fun getEpisodesList(ids: List<Int>) {
        viewModelScope.launch() {
            kotlin.runCatching {


            }.onSuccess { it ->
                _isLoading.postValue(false)
                _episodesList.value = getAllEpisodesByIds.execute(ids = ids).map {
                    GetEpisodePresentationModel().transform(it)
                }
            }.onFailure {
                _isLoading.postValue(false)
            }
        }
    }

}