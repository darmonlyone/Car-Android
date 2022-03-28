package com.sevenpeak.main.domain

import com.sevenpeak.main.domain.usecase.Result

interface UseCase<T> {
    suspend operator fun invoke(): Result<T>
}

