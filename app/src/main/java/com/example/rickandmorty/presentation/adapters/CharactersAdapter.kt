package com.example.rickandmorty.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.ItemCharactersBinding
import com.example.rickandmorty.presentation.models.character.CharacterPresentation

class CharactersAdapter : PagingDataAdapter<CharacterPresentation, CharactersAdapter.CharactersViewHolder>(
    CharactersDiffCallback()
) {

    var onCharacterItem: ((CharacterPresentation) -> Unit)? = null

    class CharactersViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemCharactersBinding.bind(itemView)

        fun bind(item: CharacterPresentation) = with(binding) {
            characterName.text = item.name
            characterSapience.text = item.species
            characterStatus.text = item.status

            when (item.gender) {
                "Male" -> itemGender.setImageResource(R.drawable.ic_male)
                "Female" -> itemGender.setImageResource(R.drawable.ic_female)
                "Unknown" -> itemGender.setImageResource(R.drawable.ic_unknown)
                else -> itemGender.setImageResource(R.drawable.ic_genderless)
            }

            Glide.with(itemView)
                .load(item.imageUrl)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_dissconect)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .centerCrop()
                .into(characterImage)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CharactersViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_characters, parent, false))

    override fun onBindViewHolder(holderContacts: CharactersViewHolder, position: Int) {
        getItem(position)?.let { holderContacts.bind(it) }
        holderContacts.itemView.setOnClickListener {
            onCharacterItem?.invoke(getItem(position)!!)
        }
    }

    private class CharactersDiffCallback : DiffUtil.ItemCallback<CharacterPresentation>() {

        override fun areItemsTheSame(
            oldItem: CharacterPresentation,
            newItem: CharacterPresentation
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CharacterPresentation,
            newItem: CharacterPresentation
        ): Boolean {
            return oldItem == newItem
        }
    }
}