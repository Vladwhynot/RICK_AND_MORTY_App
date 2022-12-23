package com.example.rickandmorty.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.ItemEpisodesInCharactersBinding
import com.example.rickandmorty.presentation.models.episode.EpisodePresentation

class EpisodeListForDetailsAdapter(
) : ListAdapter<EpisodePresentation, EpisodeListForDetailsAdapter.EpisodeListForDetailsViewHolder>(
    CharacterDetailsDiffCallback()
) {

    var onEpisodeItem: ((EpisodePresentation) -> Unit)? = null

    class EpisodeListForDetailsViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemEpisodesInCharactersBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun bind(item: EpisodePresentation) = with(binding) {
            episodeNameInItem.text = item.episode + " | " + item.name
            dataSapience.text = item.air_date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        EpisodeListForDetailsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_episodes_in_characters, parent, false)
        )

    override fun onBindViewHolder(holderContacts: EpisodeListForDetailsViewHolder, position: Int) {
        getItem(position)?.let { holderContacts.bind(it) }
        holderContacts.itemView.setOnClickListener {
            onEpisodeItem?.invoke(getItem(position)!!)
        }
    }

    private class CharacterDetailsDiffCallback : DiffUtil.ItemCallback<EpisodePresentation>() {

        override fun areItemsTheSame(
            oldItem: EpisodePresentation,
            newItem: EpisodePresentation
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: EpisodePresentation,
            newItem: EpisodePresentation
        ): Boolean {
            return oldItem == newItem
        }
    }
}