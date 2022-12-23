package com.example.rickandmorty.data.models.characters

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CHARACTERS_TABLE")
data class Characters(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "status")
    val status: String,
    @ColumnInfo(name = "species")
    val species: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "gender")
    val gender: String,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "origin")
    val origin: LinkedLocation,
    @ColumnInfo(name = "location")
    val location: LinkedLocation,
    @ColumnInfo(name = "episodes")
    val episode: List<String>
)