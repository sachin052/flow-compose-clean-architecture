package com.example.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.failure.Failure
import com.example.core.helpers.Either
import com.example.core.views.ViewStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

open class CoreViewModel : ViewModel() {
    private var mutableUIState = MutableStateFlow<ViewStatus>(ViewStatus.Inital)
    var uiState = mutableUIState.stateIn(viewModelScope,
        SharingStarted.WhileSubscribed(), ViewStatus.Inital)


    /**
     * This is the job for all coroutines started by this ViewModel.
     * Cancelling this job will cancel all coroutines started by this ViewModel.
     */
    protected val viewModelJob = Job()

    /**
     * This is the main scope for all coroutines launched by MainViewModel.
     * Since we pass viewModelJob, you can cancel all coroutines
     * launched by uiScope by calling viewModelJob.cancel()
     */
    protected val coroutineScope = CoroutineScope(Dispatchers.IO + viewModelJob)

    /**
     * Cancel all coroutines when the ViewModel is cleared
     */

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