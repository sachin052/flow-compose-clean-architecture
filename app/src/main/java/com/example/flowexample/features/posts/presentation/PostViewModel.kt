package com.example.flowexample.features.posts.presentation

import com.example.flowexample.core.helpers.Either
import com.example.flowexample.core.viewmodel.MyViewModel
import com.example.flowexample.features.posts.domain.use_cases.GetAllPostsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val getAllPostsUseCases: GetAllPostsUseCases)  : MyViewModel() {

    val allItems = executeApi { getAllPostsUseCases.invoke() }.map { value ->  when(value){
        is Either.Left -> emptyList()
        is Either.Right -> value.r
    } }

}