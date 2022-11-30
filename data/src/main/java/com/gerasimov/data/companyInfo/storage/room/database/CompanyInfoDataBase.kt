package com.gerasimov.data.companyInfo.storage.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gerasimov.data.companyInfo.storage.room.dao.CompanyInfoDao
import com.gerasimov.data.companyInfo.storage.room.data.CompanyRoom

@Database(entities = [CompanyRoom::class], version = 1)
abstract class CompanyInfoDataBase : RoomDatabase() {
    abstract fun userDao(): CompanyInfoDao
}