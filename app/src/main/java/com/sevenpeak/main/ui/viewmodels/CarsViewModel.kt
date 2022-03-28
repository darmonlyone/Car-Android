package com.sevenpeak.main.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.sevenpeak.main.domain.usecase.GetCarsUseCase
import com.sevenpeak.main.domain.usecase.Result
import kotlinx.coroutines.Dispatchers

class CarsViewModel(private val getCarsUseCase: GetCarsUseCase) : ViewModel() {

    private val result = liveData(Dispatchers.IO) {
        emit(getCarsUseCase())
    }

    val cars = result.map { if (it is Result.Success) it.value else null }
    val failureGetCarEvent = result.map {
        if (it is Result.Failure) it.throwable.message else null
    }
}