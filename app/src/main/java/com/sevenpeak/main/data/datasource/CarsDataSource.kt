package com.sevenpeak.main.data.datasource

import com.sevenpeak.main.domain.model.Car

interface CarsDataSource {
    suspend fun getCars(): Array<Car>
}