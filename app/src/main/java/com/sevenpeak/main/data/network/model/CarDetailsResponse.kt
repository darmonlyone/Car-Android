package com.sevenpeak.main.data.network.model

import com.google.gson.annotations.SerializedName

class CarDetailsResponse {
    @SerializedName("type")
    var type: String? = null

    @SerializedName("subject")
    var subject: String? = null

    @SerializedName("description")
    var description: String? = null
}