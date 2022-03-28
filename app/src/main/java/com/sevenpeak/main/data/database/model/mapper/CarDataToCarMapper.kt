package com.sevenpeak.main.data.database.model.mapper

import com.sevenpeak.main.common.Mapper
import com.sevenpeak.main.data.database.model.CarData
import com.sevenpeak.main.domain.model.Car

class CarDataToCarMapper : Mapper<CarData, Car> {
    override fun map(from: CarData): Car {
        return Car(
            title = from.title,
            date = from.date,
            ingress = from.ingress,
            imageUrl = from.imageUrl
        )
    }
}