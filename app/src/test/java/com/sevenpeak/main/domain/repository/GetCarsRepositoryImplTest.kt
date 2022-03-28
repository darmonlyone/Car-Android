package com.sevenpeak.main.domain.repository

import com.sevenpeak.main.data.datasource.CarsDataSource
import com.sevenpeak.main.domain.model.Car
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.util.*

class GetCarsRepositoryImplTest {

    private lateinit var getCarsRepository: GetCarsRepositoryImpl

    private val carsDataSource: CarsDataSource = mock()

    @Before
    fun setUp() = runBlocking {
        getCarsRepository = GetCarsRepositoryImpl(carsDataSource)
    }

    @Test
    fun testGetEmptyCars() = runBlocking {
        whenever(carsDataSource.getCars()).thenReturn(emptyArray())
        assertTrue(carsDataSource.getCars().isEmpty())
    }

    @Test
    fun testGetCars() = runBlocking {
        whenever(carsDataSource.getCars()).thenReturn(
            arrayOf(
                Car(
                    "test",
                    Date(),
                    "test test",
                    "url test"
                )
            )
        )
        assertTrue(carsDataSource.getCars().isNotEmpty())
    }
}