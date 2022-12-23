package com.example.rickandmorty.data.mapper.entity_to_domain

interface Mapper<T, R> {
    fun transform(data: T): R
}