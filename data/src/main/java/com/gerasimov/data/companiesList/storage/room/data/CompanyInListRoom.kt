package com.gerasimov.data.companiesList.storage.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CompanyInListRoom(
    @PrimaryKey(autoGenerate = true)
    val uid: Int,
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "img")
    val img: String,
)