package com.example.feature.posts.domain.use_cases

import com.example.feature.posts.domain.repo.PostRepo


open class GetAllPostsUseCasesTest(postRepoImplTest: PostRepo): GetAllPostsUseCases(postRepoImplTest){

}