package com.gerasimov.data.companiesList.storage.room.dao

import androidx.room.*
import com.gerasimov.data.companiesList.storage.room.data.CompanyInListRoom

@Dao
interface CompaniesListDao {
    @Query("SELECT * FROM CompanyInListRoom")
    fun getAll(): List<CompanyInListRoom>?

    @Insert
    fun insertAll(vararg companies: CompanyInListRoom)
}