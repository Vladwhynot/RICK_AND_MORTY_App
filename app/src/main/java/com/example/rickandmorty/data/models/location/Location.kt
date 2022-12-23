package com.example.rickandmorty.data.models.location

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LOCATIONS_TABLE")
data class Location(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "dimension")
    val dimension: String,
    @ColumnInfo(name = "residents")
    val residents: List<String>
)