package com.gerasimov.domain.companyById.model

import com.gerasimov.domain.companyById.data.CompanyInfo

interface CompanyInfoRepository {
    suspend fun getCompanyInfoById(id: Int): CompanyInfo
}