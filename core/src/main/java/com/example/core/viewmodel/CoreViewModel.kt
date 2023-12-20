package com.example.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.failure.Failure
import com.example.core.helpers.Either
import com.example.core.views.ViewStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

open class CoreViewModel : ViewModel() {
    private var mutableUIState = MutableStateFlow<ViewStatus>(ViewStatus.Inital)
    var uiState = mutableUIState.stateIn(viewModelScope,
        SharingStarted.WhileSubscribed(), ViewStatus.Inital)


    //    helper function to execute the api
    fun <T> executeApi(call: suspend () -> Flow<Either<Failure, T>>): Flow<Either<Failure, T>> {
        return flow {

                mutableUIState.value= ViewStatus.Loading
                call.invoke().collect { value ->

                    when (value) {
                        is Either.Left -> {
                            mutableUIState.value= ViewStatus.Error("Something went wrong", action = {
                                executeApi(call)
                            })
                            emit(value = value)
                        }
                        is Either.Right -> {
                            mutableUIState.value= ViewStatus.Success
                            emit(value = value)
                        }
                    }
                }

        }
    }


}