package com.example.flowexample.features.posts.domain.use_cases

import com.example.flowexample.features.posts.domain.repo.PostRepo

open class GetAllPostsUseCasesTest(postRepoImplTest: PostRepo): GetAllPostsUseCases(postRepoImplTest){

}