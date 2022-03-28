package com.sevenpeak.main.domain.repository

import com.sevenpeak.main.domain.model.Car

interface GetCarsRepository {
    suspend fun getCars(): Array<Car>
}