package com.gerasimov.data.companyInfo.storage.room

import android.content.Context
import androidx.room.Room
import com.gerasimov.data.companyInfo.storage.CompaniesInfoStorageSavable
import com.gerasimov.data.companyInfo.storage.CompanyInfoStorage
import com.gerasimov.data.companyInfo.storage.data.Company
import com.gerasimov.data.companyInfo.storage.room.data.CompanyRoom
import com.gerasimov.data.companyInfo.storage.room.database.CompanyInfoDataBase
import com.gerasimov.data.data.Resource
import com.gerasimov.data.data.Status

class RoomCompanyInfoStorage(
    applicationContext: Context
) : CompanyInfoStorage, CompaniesInfoStorageSavable {
    private val db = Room.databaseBuilder(
        applicationContext,
        CompanyInfoDataBase::class.java, "company-info-database"
    ).build().userDao()

    override suspend fun getById(id: Int): Resource<Company> {
        val company = db.findById(id)
        return if (company != null) {
            Resource(
                status = Status.SUCCESS,
                data = Company(
                    id = company.id,
                    name = company.name,
                    img = company.img,
                    description = company.description,
                    lat = company.lat,
                    lon = company.lon,
                    webSite = company.webSite,
                    phone = company.phone
                ),
                message = null
            )
        } else {
            Resource(
                status = Status.ERROR,
                data = null,
                message = "The company is not saved in the database"
            )
        }
    }

    override suspend fun saveCompany(company: Company) {
        db.addCompanyInfo(
            CompanyRoom(
                uid = company.id,
                id = company.id,
                name = company.name,
                img = company.img,
                description = company.description,
                lat = company.lat,
                lon = company.lon,
                webSite = company.webSite,
                phone = company.phone
            )
        )
    }
}