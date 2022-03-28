package com.sevenpeak.main.data.network.api

import com.sevenpeak.main.data.network.model.CarListResponse
import retrofit2.http.GET

interface GetCarsApi {

    @GET("article/get_articles_list")
    suspend fun getCarList(): CarListResponse

}