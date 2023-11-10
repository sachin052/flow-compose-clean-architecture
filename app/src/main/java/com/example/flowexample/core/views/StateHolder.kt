package com.example.flowexample.core.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.flowexample.core.views.ViewStatus
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun LoadingView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray.copy(alpha = 0.5f)),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(color = Color.White)
    }
}

@Composable
fun ErrorView(errorState: ViewStatus.Error) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray.copy(alpha = 0.5f)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Error: ${errorState.message}",
                textAlign = TextAlign.Center,
                color = Color.Red
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    errorState.action?.invoke()
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = stringResource(id = errorState.buttonText))
            }
        }
    }
}
