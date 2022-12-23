package com.example.rickandmorty.data.models.page_keys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "EPISODES_PAGE_KEYS")
data class EpisodesPageKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name = "prevPage")
    val prevPage: Int?,
    @ColumnInfo(name = "nextPage")
    val nextPage: Int?
)