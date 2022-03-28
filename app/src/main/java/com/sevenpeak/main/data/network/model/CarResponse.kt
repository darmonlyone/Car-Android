package com.sevenpeak.main.data.network.model

import com.google.gson.annotations.SerializedName

class CarResponse {
    @SerializedName("id")
    var id: Int? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("dateTime")
    var dateTime: String? = null

    @SerializedName("tags")
    var tags: Array<String>? = null

    @SerializedName("content")
    var carDetails: Array<CarDetailsResponse>? = null

    @SerializedName("ingress")
    var ingress: String? = null

    @SerializedName("image")
    var image: String? = null

    @SerializedName("created")
    var created: Int? = null

    @SerializedName("changed")
    var changed: Int? = null
}