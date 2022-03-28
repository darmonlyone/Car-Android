package com.sevenpeak.main.data.network.remote

import com.sevenpeak.main.data.network.model.CarListResponse

interface CarsRemote {
    suspend fun getCars(): CarListResponse
}