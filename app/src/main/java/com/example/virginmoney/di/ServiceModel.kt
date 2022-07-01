package com.example.virginmoney.di

import com.example.virginmoney.API.ApiService
import com.example.virginmoney.model.Repository
import com.example.virginmoney.model.RepositoryImp

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://61e947967bc0550017bc61bf.mockapi.io/api/v1/"

@Module
@InstallIn(SingletonComponent ::class)
class ServiceModel {

    @Provides
    fun provideApiService(): ApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    @Provides
    fun provideRepositoryLayer(service: ApiService) : Repository =
        RepositoryImp.RepositoryImpl(service)

    @Provides
    fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO

}