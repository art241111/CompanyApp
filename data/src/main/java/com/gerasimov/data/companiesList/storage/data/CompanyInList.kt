package com.gerasimov.data.companiesList.storage.data

import com.google.gson.annotations.SerializedName

class CompanyInList(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("img")
    val image: String
)