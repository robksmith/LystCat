package com.lyst.cat.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.lyst.cat.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule()
{
    @Provides
    @Singleton
    fun provideGson(): Gson
    {
        val builder = GsonBuilder()
        builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()
        return builder.create()
    }
}