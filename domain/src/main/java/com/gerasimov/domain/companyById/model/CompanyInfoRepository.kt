package com.gerasimov.domain.companyById.model

import com.gerasimov.data.data.Resource
import com.gerasimov.domain.companyById.data.CompanyInfo

interface CompanyInfoRepository {
    suspend fun getCompanyInfoById(id: Int): Resource<CompanyInfo>
}