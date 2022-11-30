package com.gerasimov.data.companyInfo.storage.room.dao

import androidx.room.*
import com.gerasimov.data.companyInfo.storage.room.data.CompanyRoom

@Dao
interface CompanyInfoDao {
    @Query("SELECT * FROM companyRoom WHERE id LIKE :id LIMIT 1")
    fun findById(id: Int): CompanyRoom?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCompanyInfo(companyRoom: CompanyRoom)
}