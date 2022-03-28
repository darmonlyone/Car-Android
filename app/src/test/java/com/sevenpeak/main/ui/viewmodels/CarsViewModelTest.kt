package com.sevenpeak.main.ui.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sevenpeak.main.domain.model.Car
import com.sevenpeak.main.domain.usecase.GetCarsUseCase
import com.sevenpeak.main.domain.usecase.Result
import com.sevenpeak.main.utility.getOrAwaitValue
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.util.*

class CarsViewModelTest {

    private lateinit var carsViewModel: CarsViewModel
    private val getCarsUseCase: GetCarsUseCase = mock()

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() = runBlocking {
        carsViewModel = CarsViewModel(getCarsUseCase)
    }

    @Test
    fun testInitValue() = runBlocking {
        assertNull(carsViewModel.cars.getOrAwaitValue())
        assertNull(carsViewModel.failureGetCarEvent.getOrAwaitValue())
    }

    @Test
    fun testSuccessEvent() = runBlocking {
        whenever(getCarsUseCase()).thenReturn(
            Result.Success(
                arrayOf(
                    Car(
                        "Test",
                        Date(),
                        "test ingress",
                        "image url"
                    )
                )
            )
        )
        assertFalse(carsViewModel.cars.getOrAwaitValue().isNullOrEmpty())
        assertNull(carsViewModel.failureGetCarEvent.getOrAwaitValue())
    }

    @Test
    fun testFailureEvent() = runBlocking {
        whenever(getCarsUseCase()).thenReturn(
            Result.Failure(RuntimeException("Error"))
        )
        assertEquals(carsViewModel.failureGetCarEvent.getOrAwaitValue(), "Error")
        assertNull(carsViewModel.cars.getOrAwaitValue())
    }
}