package com.sevenpeak.main.data.network.model

import com.google.gson.annotations.SerializedName

class CarListResponse {
    @SerializedName("status")
    var status: String? = null

    @SerializedName("content")
    var cars: Array<CarResponse>? = null

    @SerializedName("serverTime")
    var serverTime: String? = null

}