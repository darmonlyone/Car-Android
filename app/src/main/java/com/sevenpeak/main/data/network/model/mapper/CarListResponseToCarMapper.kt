package com.sevenpeak.main.data.network.model.mapper

import com.sevenpeak.main.common.Mapper
import com.sevenpeak.main.data.network.model.CarResponse
import com.sevenpeak.main.domain.model.Car
import java.text.SimpleDateFormat
import java.util.*

class CarListResponseToCarMapper : Mapper<CarResponse, Car> {
    override fun map(from: CarResponse): Car {

        return Car(
            title = from.title ?: "",
            date = formatDate(from.dateTime ?: ""),
            ingress = from.ingress ?: "",
            imageUrl = from.image ?: ""
        )
    }

    private fun formatDate(date: String): Date? {
        return SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.US).parse(date)
    }
}