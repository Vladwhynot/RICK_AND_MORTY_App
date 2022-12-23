package com.example.rickandmorty.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.FragmentManager
import androidx.paging.ExperimentalPagingApi
import com.example.rickandmorty.R
import com.example.rickandmorty.presentation.screens.characters.character_details_fragment.CharacterDetailsFragment
import com.example.rickandmorty.presentation.screens.characters.characters_fragment.CharactersFragment
import com.example.rickandmorty.presentation.screens.episodes.episode_details_fragment.EpisodeDetailsFragment
import com.example.rickandmorty.presentation.screens.episodes.episodes_filter_fragment.EpisodeFiltersFragment
import com.example.rickandmorty.presentation.screens.episodes.episodes_fragment.EpisodesFragment
import com.example.rickandmorty.presentation.screens.locations.location_details_fragment.LocationDetailsFragment
import com.example.rickandmorty.presentation.screens.locations.locations_fragment.LocationsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.ExperimentalCoroutinesApi

private const val open_locationsDetailFragment = "OPEN_LocationsDetailFragment"
private const val locations_detail_fragment = "LOCATIONS_DETAIL_FRAGMENT"
private const val open_episodesDetailFragment = "OPEN_EpisodesDetailFragment"
private const val episodes_detail_fragment = "EPISODES_DETAIL_FRAGMENT"
private const val open_character_detailFragment = "OPEN_CharacterDetailFragment"
private const val characters_detail_fragment = "CHARACTERS_DETAIL_FRAGMENT"
private const val locations_fragment_arg = "LOCATIONS_FRAGMENT_ARG"
private const val open_locationsFragmentWithArg = "OPEN_LocationsFragmentWithArg"
private const val episodes_fragment_arg = "EPISODES_FRAGMENT_ARG"
private const val open_episodesFragmentWithArg = "OPEN_EpisodesFragmentWithArg"
private const val characters_fragment_arg = "CHARACTERS_FRAGMENT_ARG"
private const val episodes_filter_fragment = "EPISODES_FILTER_FRAGMENT"
private const val locations_fragment = "LOCATIONS_FRAGMENT"
private const val add_first_fragment = "ADD FIRST FRAGMENT"
private const val open_charactersFragmentWithArg = "OPEN_CharactersFragmentWithArg"
private const val characters_fragment = "CHARACTERS_FRAGMENT"
private const val open_characters_fragment = "OPEN_CHARACTERS_FRAGMENT"
private const val episodes_fragment = "EPISODES_FRAGMENT"
private const val open_episode_fragment = "OPEN_EPISODE_FRAGMENT"
private const val open_location_fragment = "OPEN_LOCATION_FRAGMENT"

@ExperimentalPagingApi
class RickAndMortyActivity : AppCompatActivity(), Navigator {

    private val vm: SplashScreen by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                vm.isLoading.value
            }
        }
        setContentView(R.layout.rick_and_morty_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(
                    R.id.container_navigator,
                    CharactersFragment(),
                    add_first_fragment
                ).commit()
        } else {
            if (supportFragmentManager.backStackEntryCount == 0) {
                supportFragmentManager.popBackStack(add_first_fragment, 0)
            } else {
                val backEntry: FragmentManager.BackStackEntry =
                    supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1)
                val tag = backEntry.name
                supportFragmentManager.popBackStack(tag, 0)
            }
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.charactersFragment -> {
                    openCharactersFragment()
                    true
                }
                R.id.locationsFragment -> {
                    openLocationsFragment()
                    true
                }
                R.id.episodesFragment -> {
                    openEpisodesFragment()
                    true
                }
                else -> false
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class, kotlinx.coroutines.FlowPreview::class)
    override fun onBackPressed() {

        if (listOf(
                characters_fragment,
                open_charactersFragmentWithArg,
                add_first_fragment,
                open_characters_fragment
            ).any {
                val fragment: CharactersFragment? =
                    supportFragmentManager.findFragmentByTag(it) as CharactersFragment?
                fragment != null && fragment.isVisible
            }) finish()
        super.onBackPressed()
    }

    override fun openCharactersFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container_navigator,
                CharactersFragment(),
                characters_fragment
            ).addToBackStack(open_characters_fragment)
            .commit()
        supportFragmentManager.popBackStack(characters_fragment, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    override fun openEpisodesFragment() {
        if ( supportFragmentManager.backStackEntryCount > 0 ) {
            val backEntry: FragmentManager.BackStackEntry =
                supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1)
            val tag = backEntry.name
            if(tag == open_episode_fragment) return
        }

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container_navigator,
                EpisodesFragment(),
                episodes_fragment
            ).addToBackStack(open_episode_fragment)
            .commit()
    }

    override fun openLocationsFragment() {
        if ( supportFragmentManager.backStackEntryCount > 0 ) {
            val backEntry: FragmentManager.BackStackEntry =
                supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1)
            val tag = backEntry.name
            if(tag == open_location_fragment) return
        }

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container_navigator,
                LocationsFragment(),
                locations_fragment
            ).addToBackStack(open_location_fragment)
            .commit()
    }

    override fun openEpisodesFilterFragment() {
        EpisodeFiltersFragment().show(supportFragmentManager, episodes_filter_fragment)
    }

    @OptIn(ExperimentalCoroutinesApi::class, kotlinx.coroutines.FlowPreview::class)
    override fun openCharactersFragmentWithArg(
        status: String?,
        gender: String?,
        species: String?,
        type: String?
    ) {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container_navigator,
                CharactersFragment.newInstance(
                    gender = gender,
                    status = status,
                    species = species,
                    type = type
                ),
                characters_fragment_arg
            ).addToBackStack(open_charactersFragmentWithArg)
            .commit()
    }

    @OptIn(ExperimentalCoroutinesApi::class, kotlinx.coroutines.FlowPreview::class)
    override fun openEpisodesFragmentWithArg(episode: String?) {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container_navigator,
                EpisodesFragment.newInstance(
                    episode = episode
                ),
                episodes_fragment_arg
            ).addToBackStack(open_episodesFragmentWithArg)
            .commit()
    }

    @OptIn(ExperimentalCoroutinesApi::class, kotlinx.coroutines.FlowPreview::class)
    override fun openLocationsFragmentWithArg(type: String?, dimension: String?) {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container_navigator,
                LocationsFragment.newInstance(
                    types = type,
                    dimensions = dimension,
                ),
                locations_fragment_arg
            ).addToBackStack(open_locationsFragmentWithArg)
            .commit()
    }

    override fun openCharacterDetailFragment(characterId: Int) {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container_navigator,
                CharacterDetailsFragment.newInstance(
                    characterId = characterId
                ),
                characters_detail_fragment
            ).addToBackStack(open_character_detailFragment)
            .commit()
    }

    override fun openEpisodesDetailFragment(episodeId: Int) {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container_navigator,
                EpisodeDetailsFragment.newInstance(
                    episodeId = episodeId
                ),
                episodes_detail_fragment
            ).addToBackStack(open_episodesDetailFragment)
            .commit()
    }

    override fun openLocationsDetailFragment(locationId: Int) {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container_navigator,
                LocationDetailsFragment.newInstance(
                    locationId = locationId
                ),
                locations_detail_fragment
            ).addToBackStack(open_locationsDetailFragment)
            .commit()
    }

    override fun backButton() {
        onBackPressed()
    }

}