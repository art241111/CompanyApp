package com.gerasimov.data.companiesList.storage.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gerasimov.data.companiesList.storage.room.dao.CompaniesListDao
import com.gerasimov.data.companiesList.storage.room.data.CompanyInListRoom

@Database(entities = [CompanyInListRoom::class], version = 1)
abstract class CompaniesListDataBase : RoomDatabase() {
    abstract fun userDao(): CompaniesListDao
}