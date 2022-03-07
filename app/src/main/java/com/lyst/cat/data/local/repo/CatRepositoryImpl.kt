package com.lyst.cat.data.local.repo

import com.lyst.cat.domain.repository.CatRepository
import com.lyst.cat.data.thecatapi.TheCatApi
import com.lyst.cat.data.thecatapi.dto.Breed
import com.lyst.cat.data.thecatapi.dto.BreedById
import javax.inject.Inject

class CatRepositoryImpl @Inject constructor(private val api: TheCatApi) : CatRepository
{
    override suspend fun getAllBreeds(): List<Breed> {
        return api.getAllBreeds()
    }

    override suspend fun searchBreeds(searchTerm: String): List<Breed> {
        return api.searchBreeds(searchTerm)
    }

    override suspend fun getCatById(catId: String): List<BreedById> {
        return api.getBreedById(catId)
    }
}