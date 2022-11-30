package com.gerasimov.data.companyInfo.storage.room

import com.gerasimov.data.companyInfo.storage.CompanyInfoStorage
import com.gerasimov.data.companyInfo.storage.data.Company
import com.gerasimov.data.data.Resource

class RoomCompanyInfoStorage : CompanyInfoStorage {
    override suspend fun getById(id: Int): Resource<Company> {
        TODO("Not yet implemented")
    }
}