package com.sevenpeak.main.domain.usecase

import com.sevenpeak.main.domain.UseCase
import com.sevenpeak.main.domain.model.Car
import com.sevenpeak.main.domain.repository.GetCarsRepository

class GetCarsUseCase(private val getCarsRepository: GetCarsRepository) : UseCase<Array<Car>> {

    override suspend fun invoke(): Result<Array<Car>> {
        return try {
            val cars = getCarsRepository.getCars()
            Result.Success(cars)
        } catch (e: Exception) {
            Result.Failure(e)
        }
    }
}