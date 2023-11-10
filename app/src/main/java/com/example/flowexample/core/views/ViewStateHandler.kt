package com.example.flowexample.core.views

import androidx.compose.runtime.Composable
import com.example.flowexample.core.views.ErrorView
import com.example.flowexample.core.views.LoadingView
import com.example.flowexample.core.views.ViewStatus

@Composable
fun<T> ViewStateHandler(
    viewState: ViewStatus,
    onLoading: @Composable () -> Unit = { LoadingView() },
    onError: @Composable (ViewStatus.Error) -> Unit = { ErrorView(errorState = it) },
    onSuccess: @Composable () -> Unit,
) {
    when (viewState) {
        is ViewStatus.Loading -> onLoading()
        is ViewStatus.Success -> onSuccess()
        is ViewStatus.Error -> onError(viewState)
    }
}
