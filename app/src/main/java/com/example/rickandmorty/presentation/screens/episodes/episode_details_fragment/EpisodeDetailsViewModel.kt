package com.example.rickandmorty.presentation.screens.episodes.episode_details_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.domain.interactors.characters.characters_get_all.GetAllCharactersByIds
import com.example.rickandmorty.domain.interactors.episodes.episode_details.GetEpisodeById
import com.example.rickandmorty.presentation.mapper.GetCharacterPresentationModel
import com.example.rickandmorty.presentation.mapper.GetEpisodePresentationModel
import com.example.rickandmorty.presentation.models.character.CharacterPresentation
import com.example.rickandmorty.presentation.models.episode.EpisodePresentation
import kotlinx.coroutines.launch

class EpisodeDetailsViewModel(
    private val getEpisodeById: GetEpisodeById,
    private val getAllCharactersByIds: GetAllCharactersByIds
) : ViewModel() {

    private val _episodeDetails = MutableLiveData<EpisodePresentation>()
    val episodeDetails: MutableLiveData<EpisodePresentation> = _episodeDetails

    private val _charactersList = MutableLiveData<List<CharacterPresentation>>()
    val charactersList: MutableLiveData<List<CharacterPresentation>> = _charactersList

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = _isLoading

    fun getEpisode(id: Int) {
        viewModelScope.launch {
            _episodeDetails.value =
                GetEpisodePresentationModel().transform(getEpisodeById.execute(id = id))
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