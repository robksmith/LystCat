package com.lyst.cat.di

import com.lyst.cat.common.Constants
import com.lyst.cat.data.thecatapi.TheCatApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule()
{
    @Provides
    @Singleton
    fun provideCatApi(): TheCatApi
    {
        val okHttpClientBuilder = OkHttpClient.Builder()

        // interceptor - add the cat api key to the header
        okHttpClientBuilder.addInterceptor(object : Interceptor
        {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response
            {
                var request = chain.request()
                val builder: Request.Builder = request.newBuilder()

                builder.addHeader("Content-Type", "application/json")
                builder.addHeader("Accept", "application/json")
                builder.addHeader("x-api-key", Constants.THE_CAT_API_KEY)

                request = builder.build()
                return chain.proceed(request)
            }
        })

        // logging - to fix a few issues I had with the cat responses
        if (true)
        {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            okHttpClientBuilder.addInterceptor(logging)
        }

        return Retrofit.Builder()
            .baseUrl(Constants.CAT_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClientBuilder.build())
            .build()
            .create(TheCatApi::class.java)
    }
}