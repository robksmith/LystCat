package com.lyst.cat.domain.repository

import com.lyst.cat.data.thecatapi.dto.Breed
import com.lyst.cat.data.thecatapi.dto.BreedById

interface CatRepository {
    suspend fun getAllBreeds(): List<Breed>
    suspend fun searchBreeds(searchTerm:String): List<Breed>
    suspend fun getCatById(catId: String): List<BreedById>
}