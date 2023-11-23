package com.example.flowexample.features.posts.data.repo_impl

import com.example.flowexample.core.failure.Failure
import com.example.flowexample.core.helpers.Either
import com.example.flowexample.core.helpers.map
import com.example.flowexample.core.helpers.safeFlowBuilder
import com.example.flowexample.features.posts.data.datasource.remote.FakeApiService
import com.example.flowexample.features.posts.data.datasources.remote.response.GetPostApiResponse
import com.example.flowexample.features.posts.domain.mapper.toPostsEntities
import com.example.flowexample.features.posts.domain.entity.PostEntity
import com.example.flowexample.features.posts.domain.repo.PostRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PostRepoImplTest(private val fakeApiService: FakeApiService) : PostRepo {
    override suspend fun getAllPosts(): Flow<Either<Failure, List<PostEntity>>> {

        return safeFlowBuilder { fakeApiService.getAllPosts() }.map { value ->
            when (value) {
                is Either.Left -> value
                is Either.Right -> value.map(GetPostApiResponse::toPostsEntities)
            }
        }
    }
}