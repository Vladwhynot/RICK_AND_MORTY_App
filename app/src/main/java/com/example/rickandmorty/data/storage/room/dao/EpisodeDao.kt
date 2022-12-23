package com.example.rickandmorty.data.storage.room.dao

import androidx.paging.PagingSource
import androidx.room.*
import com.example.rickandmorty.data.models.episodes.Episode
import kotlinx.coroutines.flow.Flow


@Dao
interface EpisodeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllEpisodes(episodes: List<Episode?>?)

    @Query("DELETE FROM EPISODES_TABLE")
    suspend fun deleteAllEpisodes()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEpisode(episode: Episode)


    @Query(
        """SELECT * FROM EPISODES_TABLE
        WHERE (:name IS NULL OR name LIKE '%' || :name || '%')
        AND (:episode IS NULL OR episode LIKE :episode)"""
    )
    fun getFilteredEpisodes(
        name: String?,
        episode: String?,
    ): PagingSource<Int, Episode>

    @Query(
        """SELECT * FROM EPISODES_TABLE
        WHERE id IN (:ids)
        ORDER BY id ASC"""
    )
    suspend fun getEpisodesByIds(ids: List<Int>): List<Episode>

    @Query("SELECT * FROM EPISODES_TABLE WHERE id = :id")
    suspend fun getEpisodeById(id: Int): Episode

    @Query(
        """SELECT episode FROM EPISODES_TABLE ORDER BY episode ASC"""
    )
    fun getEpisodes(): Flow<List<String>>
}