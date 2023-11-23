package com.example.flowexample.features.posts.domain.repo

import com.example.core.failure.Failure
import com.example.core.helpers.Either
import com.example.flowexample.features.posts.domain.entity.PostEntity
import kotlinx.coroutines.flow.Flow

interface  PostRepo {

    suspend fun getAllPosts(): Flow<Either<Failure, List<PostEntity>>>
}