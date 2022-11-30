package com.gerasimov.data.companiesList.storage.room

import com.gerasimov.data.companiesList.storage.CompaniesListStorage
import com.gerasimov.data.companiesList.storage.data.Companies
import com.gerasimov.data.data.Resource

class RoomCompaniesListStorage : CompaniesListStorage {
    override suspend fun getList(): Resource<Companies> {
        TODO("Not yet implemented")
    }
}