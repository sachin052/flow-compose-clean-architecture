package com.example.feature.posts.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.views.ViewStateHandler
import com.example.feature.posts.R
import com.example.feature.posts.domain.entity.PostEntity
import com.example.flowexample.features.posts.presentation.PostViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PostScreen(postViewModel: PostViewModel = hiltViewModel()) {
    val state = postViewModel.uiState.collectAsState()

    val allPostItems = postViewModel.allItems.collectAsState(initial = emptyList()).value
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.post_details)) },
                navigationIcon = {
                    IconButton(onClick = {  }) {
                        Icon(Icons.Default.Home, contentDescription = stringResource(R.string.back))
                    }
                }
            )
        },
        content = {
            ViewStateHandler<List<PostEntity>>(viewState = state.value) {
                LazyColumn(modifier = Modifier.padding(it)) {
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
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Title: ${postEntity.postTitle}",
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = "Body: ${postEntity.postBody}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}