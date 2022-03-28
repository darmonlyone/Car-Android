package com.sevenpeak.main.ui.model.mapper

import com.sevenpeak.main.domain.model.Car
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

class CarToUiCarMapperTest {
    lateinit var carToUiCarMapper: CarToUiCarMapper

    @Before
    fun setUp() {
        carToUiCarMapper = CarToUiCarMapper()
    }

    @Test
    fun testMapCarToUiCar() {
        val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm")
        val mockCarData =
            Car("test", simpleDateFormat.parse("10/02/2000 12:12"), "test ingress", "imageurl")
        val result = carToUiCarMapper.map(mockCarData)
        assertEquals("test", result.title)
        assertEquals("test ingress", result.ingress)
        assertEquals("10 February 2000, 12:12", result.date)
        assertEquals("imageurl", result.imageUrl)
    }

    @Test
    fun testMapCarToUiCarWithThisYear() {
        val cal = Calendar.getInstance()
        cal.set(cal.get(Calendar.YEAR), 2, 12, 5, 11)
        val mockCarData =
            Car("test", cal.time, "test ingress", "imageurl")
        val result = carToUiCarMapper.map(mockCarData)
        assertEquals("test", result.title)
        assertEquals("test ingress", result.ingress)
        assertEquals("12 March, 05:11", result.date)
        assertEquals("imageurl", result.imageUrl)
    }
}