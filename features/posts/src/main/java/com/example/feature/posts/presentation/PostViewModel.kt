package com.example.flowexample.features.posts.presentation

import com.example.core.helpers.Either
import com.example.core.viewmodel.CoreViewModel
import com.example.feature.posts.domain.use_cases.GetAllPostsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val getAllPostsUseCases: GetAllPostsUseCases)  : CoreViewModel() {

    val allItems = executeApi { getAllPostsUseCases.invoke() }.map { value ->  when(value){
        is Either.Left -> emptyList()
        is Either.Right -> value.r
    } }

}