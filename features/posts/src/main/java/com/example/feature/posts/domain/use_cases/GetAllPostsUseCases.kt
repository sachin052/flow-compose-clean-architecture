package com.example.feature.posts.domain.use_cases

import com.example.core.failure.Failure
import com.example.core.helpers.Either
import com.example.core.usecase.UseCaseNoParams
import com.example.feature.posts.domain.entity.PostEntity
import com.example.feature.posts.domain.repo.PostRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

open class GetAllPostsUseCases @Inject constructor(private val postRepo: PostRepo) :
    UseCaseNoParams<List<PostEntity>> {
    override suspend fun invoke(): Flow<Either<Failure, List<PostEntity>>> {
        return postRepo.getAllPosts()
    }

}