package com.sevenpeak.main.data.database.local

import androidx.room.Room
import com.sevenpeak.main.Application
import com.sevenpeak.main.data.database.CarDatabase
import com.sevenpeak.main.data.database.model.CarData

class CarsLocalImpl : CarsLocal {
    private val database: CarDatabase = Room.databaseBuilder(
        Application.applicationContext(),
        CarDatabase::class.java, "car"
    ).build()

    override suspend fun getCars(): Array<CarData> {
        return database.carDao().getAll()
    }

    override suspend fun clear() {
        database.carDao().clear()
    }

    override suspend fun insertAll(cars: Array<CarData>) {
        database.carDao().insertAll(*cars)
    }

}