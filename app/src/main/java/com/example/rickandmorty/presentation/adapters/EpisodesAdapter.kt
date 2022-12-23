package com.example.rickandmorty.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.ItemEpisodesBinding
import com.example.rickandmorty.presentation.models.episode.EpisodePresentation

class EpisodesAdapter : PagingDataAdapter<EpisodePresentation, EpisodesAdapter.EpisodesViewHolder>(
    EpisodesDiffCallback()
) {

    var onEpisodeItem: ((EpisodePresentation) -> Unit)? = null


    class EpisodesViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemEpisodesBinding.bind(itemView)

        fun bind(item: EpisodePresentation) = with(binding) {

            nameEpisodeItem.text = item.name
            dataEpisodeItem.text = item.air_date
            numberEpisodeItem.text = item.episode
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        EpisodesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_episodes, parent, false))


    override fun onBindViewHolder(holderContacts: EpisodesViewHolder, position: Int) {
        getItem(position)?.let { holderContacts.bind(it) }
        holderContacts.itemView.setOnClickListener {
            onEpisodeItem?.invoke(getItem(position)!!)
        }
    }

    private class EpisodesDiffCallback : DiffUtil.ItemCallback<EpisodePresentation>() {

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