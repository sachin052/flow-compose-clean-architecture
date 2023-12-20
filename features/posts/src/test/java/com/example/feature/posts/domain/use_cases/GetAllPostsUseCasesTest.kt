package com.example.feature.posts.domain.use_cases

import com.example.flowexample.features.posts.domain.repo.PostRepo

open class GetAllPostsUseCasesTest(postRepoImplTest: PostRepo): GetAllPostsUseCases(postRepoImplTest){

}