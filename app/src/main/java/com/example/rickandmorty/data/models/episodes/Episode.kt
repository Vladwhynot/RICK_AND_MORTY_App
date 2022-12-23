package com.example.rickandmorty.data.models.episodes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "EPISODES_TABLE")
data class Episode(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "characters")
    val characters: List<String>,
    @ColumnInfo(name = "air_date")
    val air_date: String,
    @ColumnInfo(name = "episode")
    val episode: String,
)