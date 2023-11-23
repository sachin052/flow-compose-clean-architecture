package com.example.core.usecase

interface UseCase<Params, Result> {
    suspend operator fun invoke(params: Params): Result
}