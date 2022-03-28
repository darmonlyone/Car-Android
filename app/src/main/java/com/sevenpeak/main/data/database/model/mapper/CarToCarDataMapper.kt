package com.sevenpeak.main.data.database.model.mapper

import com.sevenpeak.main.common.Mapper
import com.sevenpeak.main.data.database.model.CarData
import com.sevenpeak.main.domain.model.Car

class CarToCarDataMapper : Mapper<Car, CarData> {
    override fun map(from: Car): CarData {
        return CarData(
            title = from.title,
            date = from.date,
            ingress = from.ingress,
            imageUrl = from.imageUrl
        )
    }
}