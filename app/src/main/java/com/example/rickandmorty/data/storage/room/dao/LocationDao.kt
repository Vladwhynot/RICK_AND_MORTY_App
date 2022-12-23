package com.example.rickandmorty.data.storage.room.dao

import androidx.paging.PagingSource
import androidx.room.*
import com.example.rickandmorty.data.models.location.Location
import kotlinx.coroutines.flow.Flow


@Dao
interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllLocations(locations: List<Location?>?)

    @Query("DELETE FROM LOCATIONS_TABLE")
    suspend fun deleteAllLocations()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocation(location: Location)

    @Query(
        """SELECT * FROM LOCATIONS_TABLE
        WHERE (:name IS NULL OR name LIKE '%' || :name || '%')
        AND (:type IS NULL OR type LIKE :type)
        AND (:dimension IS NULL OR dimension LIKE :dimension)"""
    )
    fun getFilteredLocations(
        name: String?,
        type: String?,
        dimension: String?,
    ):  PagingSource<Int, Location>


    @Query("SELECT * FROM LOCATIONS_TABLE WHERE id = :id")
    suspend fun getLocationById(id: Int): Location

    @Query(
        """SELECT type FROM LOCATIONS_TABLE ORDER BY type ASC"""
    )
    fun getTypes(): Flow<List<String>>

    @Query(
        """SELECT dimension FROM LOCATIONS_TABLE ORDER BY dimension ASC"""
    )
    fun getDimensions(): Flow<List<String>>
}