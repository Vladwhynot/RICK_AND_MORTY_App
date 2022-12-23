package com.example.rickandmorty.presentation.screens.characters.characters_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.ExperimentalPagingApi
import com.example.rickandmorty.domain.interactors.characters.characters_get_all.GetAllCharacters

@ExperimentalPagingApi
class CharactersViewModelFactory(
    private val getAllCharacters: GetAllCharacters
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CharactersViewModel(
            getAllCharacters = getAllCharacters
        ) as T
    }
}