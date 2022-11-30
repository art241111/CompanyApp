package com.gerasimov.data.companyInfo.storage.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CompanyRoom(
    @PrimaryKey(autoGenerate = true)
    val uid: Int,
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "img")
    val img: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "lat")
    val lat: String,
    @ColumnInfo(name = "lon")
    val lon: String,
    @ColumnInfo(name = "webSite")
    val webSite: String,
    @ColumnInfo(name = "phone")
    val phone: String
)