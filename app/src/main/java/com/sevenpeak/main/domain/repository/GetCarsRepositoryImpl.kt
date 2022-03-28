package com.sevenpeak.main.domain.repository

import com.sevenpeak.main.data.datasource.CarsDataSource
import com.sevenpeak.main.domain.model.Car

class GetCarsRepositoryImpl(private val carsDataSource: CarsDataSource) : GetCarsRepository {

    override suspend fun getCars(): Array<Car> {
        return carsDataSource.getCars()
    }

}