package com.gerasimov.data.companyInfo.storage.data

import com.google.gson.annotations.SerializedName

class Company(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("img")
    val img: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("lat")
    val lat: String,
    @SerializedName("lon")
    val lon: String,
    @SerializedName("www")
    val webSite: String,
    @SerializedName("phone")
    val phone: String
)