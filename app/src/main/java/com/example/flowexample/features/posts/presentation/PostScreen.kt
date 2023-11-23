package com.example.flowexample.features.posts.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.flowexample.R
import com.example.flowexample.core.views.ViewStateHandler
import com.example.flowexample.features.posts.domain.entity.PostEntity

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PostScreen(navController: NavHostController, postViewModel: PostViewModel = hiltViewModel()) {
    val state = postViewModel.uiState.collectAsState()

    val allPostItems = postViewModel.allItems.collectAsState(initial = emptyList()).value
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.post_details)) },
                navigationIcon = {
                    IconButton(onClick = { /* Handle navigation here */ }) {
                        Icon(Icons.Default.Home, contentDescription = stringResource(R.string.back))
                    }
                }
            )
        },
        content = {
            ViewStateHandler<List<PostEntity>>(viewState = state.value) {
                LazyColumn {
                    items(allPostItems) { post ->
                        // For each post in the list, display a PostCard
                        PostCard(post)
                    }
                }
            }
        }
    )
}

@Composable
fun PostCard(postEntity: PostEntity) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .shadow(elevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = "User ID: ${postEntity.userID}",
                style = MaterialTheme.typography.h6
            )
            Text(
                text = "Title: ${postEntity.postTitle}",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "Body: ${postEntity.postBody}",
                style = MaterialTheme.typography.body2
            )
        }
    }
}