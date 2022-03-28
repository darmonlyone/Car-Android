package com.sevenpeak.main.data.datasource

import com.sevenpeak.main.Application
import com.sevenpeak.main.data.database.local.CarsLocal
import com.sevenpeak.main.data.database.model.mapper.CarDataToCarMapper
import com.sevenpeak.main.data.database.model.mapper.CarToCarDataMapper
import com.sevenpeak.main.data.network.model.mapper.CarListResponseToCarMapper
import com.sevenpeak.main.data.network.remote.CarsRemote
import com.sevenpeak.main.domain.model.Car
import com.sevenpeak.main.utility.VerifyNetwork

class CarsDataSourceImpl(
    private val carsRemote: CarsRemote,
    private val carsLocal: CarsLocal
) : CarsDataSource {
    override suspend fun getCars(): Array<Car> {
        val cars: Array<Car>
        if (VerifyNetwork.verifyAvailableNetwork(Application.applicationContext())) {
            cars = carsRemote.getCars().cars?.map { CarListResponseToCarMapper().map(it) }
                ?.toTypedArray() ?: emptyArray()

            carsLocal.clear()
            carsLocal.insertAll(cars.map { CarToCarDataMapper().map(it) }.toTypedArray())
        } else {
            cars = carsLocal.getCars().map { CarDataToCarMapper().map(it) }.toTypedArray()
        }
        return cars
    }
}