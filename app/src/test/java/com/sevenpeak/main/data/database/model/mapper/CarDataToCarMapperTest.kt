package com.sevenpeak.main.data.database.model.mapper

import com.sevenpeak.main.data.database.model.CarData
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.text.SimpleDateFormat

class CarDataToCarMapperTest {

    lateinit var carDataToCarMapper: CarDataToCarMapper

    @Before
    fun setUp() {
        carDataToCarMapper = CarDataToCarMapper()
    }

    @Test
    fun testMapEmpty() {
        val mockCarData = CarData(0, "", null, "", "")
        val result = carDataToCarMapper.map(mockCarData)
        assertEquals("", result.title)
        assertEquals("", result.ingress)
        assertEquals(null, result.date)
        assertEquals("", result.imageUrl)
    }

    @Test
    fun testMapToCar() {
        val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
        val mockCarData =
            CarData(1, "test", simpleDateFormat.parse("10/02/1999"), "test ingress", "imageurl")
        val result = carDataToCarMapper.map(mockCarData)
        assertEquals("test", result.title)
        assertEquals("test ingress", result.ingress)
        assertEquals(simpleDateFormat.parse("10/02/1999"), result.date)
        assertEquals("imageurl", result.imageUrl)
    }
}