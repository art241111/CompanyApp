package com.gerasimov.data.companiesList.storage.room

import android.content.Context
import androidx.room.Room
import com.gerasimov.data.companiesList.storage.CompaniesListStorage
import com.gerasimov.data.companiesList.storage.CompaniesListStorageSavable
import com.gerasimov.data.companiesList.storage.data.Companies
import com.gerasimov.data.companiesList.storage.data.CompanyInList
import com.gerasimov.data.companiesList.storage.room.data.CompanyInListRoom
import com.gerasimov.data.companiesList.storage.room.database.CompaniesListDataBase
import com.gerasimov.data.data.Resource
import com.gerasimov.data.data.Status

class RoomCompaniesListStorage(applicationContext: Context) : CompaniesListStorage,
    CompaniesListStorageSavable {
    private val db = Room.databaseBuilder(
        applicationContext,
        CompaniesListDataBase::class.java, "company-list-database"
    ).build().userDao()

    override suspend fun getList(): Resource<Companies> {
        val company = db.getAll()
        return if (company != null) {
            Resource(
                status = Status.SUCCESS,
                data = Companies(
                    company.map {
                        CompanyInList(
                            id = it.id,
                            name = it.name,
                            image = it.img
                        )
                    }
                ),
                message = null
            )
        } else {
            Resource(
                status = Status.ERROR,
                data = null,
                message = "No companies are saved"
            )
        }
    }

    override suspend fun saveCompanies(companies: List<CompanyInList>) {
        db.insertAll(*companies.map {
            CompanyInListRoom(
                uid = it.id,
                id = it.id,
                name = it.name,
                img = it.image
            )
        }.toTypedArray())
    }
}