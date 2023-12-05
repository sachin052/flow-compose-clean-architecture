package com.example.core.views

import androidx.compose.runtime.Composable

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
        else -> {onLoading()}
    }
}
