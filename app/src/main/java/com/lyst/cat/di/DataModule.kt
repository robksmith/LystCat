package com.lyst.cat.di

import com.lyst.cat.common.Constants
import com.lyst.cat.data.local.repo.CatRepositoryImpl
import com.lyst.cat.data.thecatapi.TheCatApi
import com.lyst.cat.domain.repository.CatRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule()
{
    @Provides
    @Singleton
    fun provideCatRepository(api: TheCatApi): CatRepository
    {
        return CatRepositoryImpl(api)
    }
}