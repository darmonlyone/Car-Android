package com.sevenpeak.main.data.network.remote

import com.google.gson.GsonBuilder
import com.sevenpeak.main.data.network.api.GetCarsApi
import com.sevenpeak.main.data.network.model.CarListResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CarsRemoteImpl : CarsRemote {

    private val BASEURL: String = ""

    override suspend fun getCars(): CarListResponse {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()

        val service = retrofit.create(GetCarsApi::class.java)
        return service.getCarList()
    }
}