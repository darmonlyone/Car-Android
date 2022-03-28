package com.sevenpeak.main.data.database.model.mapper

import com.sevenpeak.main.domain.model.Car
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.text.SimpleDateFormat

class CarToCarDataMapperTest {

    lateinit var carToCarDataMapper: CarToCarDataMapper

    @Before
    fun setUp() {
        carToCarDataMapper = CarToCarDataMapper()
    }

    @Test
    fun testMapEmpty() {
        val mockCarData = Car("", null, "", "")
        val result = carToCarDataMapper.map(mockCarData)
        assertEquals(0, result.uid)
        assertEquals("", result.title)
        assertEquals("", result.ingress)
        assertEquals(null, result.date)
        assertEquals("", result.imageUrl)
    }

    @Test
    fun testMapToCar() {
        val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
        val mockCarData =
            Car("test", simpleDateFormat.parse("10/02/1999"), "test ingress", "imageurl")
        val result = carToCarDataMapper.map(mockCarData)
        assertEquals(0, result.uid)
        assertEquals("test", result.title)
        assertEquals("test ingress", result.ingress)
        assertEquals(simpleDateFormat.parse("10/02/1999"), result.date)
        assertEquals("imageurl", result.imageUrl)
    }
}