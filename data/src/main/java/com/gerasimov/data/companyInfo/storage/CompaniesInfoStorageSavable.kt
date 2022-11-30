package com.gerasimov.data.companyInfo.storage

import com.gerasimov.data.companyInfo.storage.data.Company

interface CompaniesInfoStorageSavable {
    suspend fun saveCompany(company: Company)
}