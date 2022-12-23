package com.example.rickandmorty.data.paging

import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.rickandmorty.data.models.location.Location
import com.example.rickandmorty.data.models.page_keys.LocationsPageKeys

interface Mediator<T,V : Any> {

     suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, V>): T

     suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, V>): T

     suspend fun getRemoteKeyForLastItem(state: PagingState<Int, V>): T

     suspend fun getKeyPageData(loadType: LoadType, state: PagingState<Int, V>): Any



















}