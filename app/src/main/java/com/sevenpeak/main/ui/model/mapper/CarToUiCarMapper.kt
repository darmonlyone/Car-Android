package com.sevenpeak.main.ui.model.mapper

import com.sevenpeak.main.common.Mapper
import com.sevenpeak.main.domain.model.Car
import com.sevenpeak.main.ui.model.UiCar
import java.text.SimpleDateFormat
import java.util.*

class CarToUiCarMapper : Mapper<Car, UiCar> {
    override fun map(from: Car): UiCar {
        return UiCar(
            title = from.title,
            date = formatDateToString(from.date),
            ingress = from.ingress,
            imageUrl = from.imageUrl
        )
    }

    private fun formatDateToString(date: Date?): String {
        date ?: return ""
        val calfrom = Calendar.getInstance(TimeZone.getDefault())
        calfrom.time = date
        val calTo = Calendar.getInstance(TimeZone.getDefault())
        calTo.time = Date()

        return if (calfrom.get(Calendar.YEAR) == calTo.get(Calendar.YEAR))
            SimpleDateFormat("dd MMMM, HH:mm", Locale.getDefault()).format(date)
        else
            SimpleDateFormat("dd MMMM yyyy, HH:mm", Locale.getDefault()).format(date)
    }
}