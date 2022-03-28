package com.sevenpeak.main.data.database.local

import com.sevenpeak.main.data.database.model.CarData

interface CarsLocal {
    suspend fun getCars(): Array<CarData>
    suspend fun clear()
    suspend fun insertAll(cars: Array<CarData>)
}