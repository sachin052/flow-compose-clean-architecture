package com.example.feature.posts.data.datasource.remote

import com.example.feature.posts.data.datasources.remote.response.GetPostApiResponse
import com.example.feature.posts.data.datasources.remote.services.PostsApiService
import retrofit2.Response

class FakeApiService: PostsApiService {
    override suspend fun getAllPosts(): Response<GetPostApiResponse> {
       return Response.success(GetPostApiResponse().apply { addAll(listOf(
           GetPostApiResponse.GetPostApiResponseItem(id = 1, title = "title", body = "body", userId = 1),
           GetPostApiResponse.GetPostApiResponseItem(id = 1, title = "title", body = "body", userId = 1),
           GetPostApiResponse.GetPostApiResponseItem(id = 1, title = "title", body = "body", userId = 1),
           GetPostApiResponse.GetPostApiResponseItem(id = 1, title = "title", body = "body", userId = 1),
           GetPostApiResponse.GetPostApiResponseItem(id = 1, title = "title", body = "body", userId = 1),
       )) })
    }
}