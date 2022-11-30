package com.gerasimov.data.companyInfo.storage

import com.gerasimov.data.companyInfo.storage.data.Company
import com.gerasimov.data.data.Resource

interface CompanyInfoStorage {
    suspend fun getById(id: Int): Resource<Company>
}