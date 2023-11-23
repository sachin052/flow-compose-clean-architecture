package com.example.core.usecase

import com.example.core.failure.Failure
import com.example.core.helpers.Either
import kotlinx.coroutines.flow.Flow


interface UseCaseNoParams<Result>  {

    suspend operator fun invoke(): Flow<Either<Failure, Result>>
}