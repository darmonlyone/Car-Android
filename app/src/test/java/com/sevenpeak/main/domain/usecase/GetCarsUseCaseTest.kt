package com.sevenpeak.main.domain.usecase

import com.sevenpeak.main.domain.model.Car
import com.sevenpeak.main.domain.repository.GetCarsRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.util.*

class GetCarsUseCaseTest {

    private lateinit var getCarsUseCase: GetCarsUseCase

    private val getCarsRepository: GetCarsRepository = mock()

    @Before
    fun setUp() = runBlocking {
        getCarsUseCase = GetCarsUseCase(getCarsRepository)
    }

    @Test
    fun testGetCarsSuccessResult() = runBlocking {
        whenever(getCarsRepository.getCars()).thenReturn(
            arrayOf(
                Car(
                    "test",
                    Date(),
                    "test test",
                    "url test"
                )
            )
        )
        assertTrue(getCarsUseCase() is Result.Success)
    }

    @Test
    fun testGetCarsFailureResult() = runBlocking {
        whenever(getCarsRepository.getCars()).thenThrow(
            RuntimeException()
        )
        assertTrue(getCarsUseCase() is Result.Failure)
    }
}