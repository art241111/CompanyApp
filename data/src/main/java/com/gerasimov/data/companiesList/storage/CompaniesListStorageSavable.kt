package com.gerasimov.data.companiesList.storage

import com.gerasimov.data.companiesList.storage.data.CompanyInList

interface CompaniesListStorageSavable {
    suspend fun saveCompanies(companies: List<CompanyInList>)
}