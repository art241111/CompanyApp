package com.gerasimov.data.companiesList.storage

import com.gerasimov.data.companiesList.storage.data.Companies
import com.gerasimov.data.data.Resource

interface CompaniesListStorage {
    suspend fun getList(): Resource<Companies>
}