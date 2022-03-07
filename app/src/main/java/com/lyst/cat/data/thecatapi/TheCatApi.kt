package com.lyst.cat.data.thecatapi

import com.lyst.cat.data.thecatapi.dto.Breed
import com.lyst.cat.data.thecatapi.dto.BreedById
import retrofit2.http.GET
import retrofit2.http.Query

interface TheCatApi {
    // for home page
    @GET("/v1/breeds")
    suspend fun getAllBreeds(): List<Breed>

    // for search page
    @GET("/v1/breeds/search")
    suspend fun searchBreeds(@Query("q") searchTerm:String): List<Breed>

    // for cat detail page to get list of images
    @GET("/v1/images/search")
    suspend fun getBreedById(@Query("breed_id") breedId:String, @Query("limit") limit:Int=5): List<BreedById>
}