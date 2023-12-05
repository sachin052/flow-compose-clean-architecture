package com.example.flowexample.di

import com.example.flowexample.features.posts.data.datasources.remote.services.PostsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiServiceModule {
    @Provides
    @Singleton
    fun provideSearchAppService(retrofit: Retrofit): PostsApiService {
        return retrofit.create(PostsApiService::class.java)
    }
}