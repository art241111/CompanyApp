package com.gerasimov.data.companiesList.storage.retrofit.data

import com.google.gson.annotations.SerializedName

class CompanyInListRetrofit(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("img")
    val image: String
)