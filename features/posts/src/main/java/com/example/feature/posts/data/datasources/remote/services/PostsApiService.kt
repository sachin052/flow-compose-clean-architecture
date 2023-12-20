package com.example.feature.posts.data.datasources.remote.services

import com.example.feature.posts.data.datasources.remote.response.GetPostApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface PostsApiService {

    @GET(com.example.core.constants.AppConstants.GET_POSTS)
    suspend fun getAllPosts():Response<GetPostApiResponse>
}