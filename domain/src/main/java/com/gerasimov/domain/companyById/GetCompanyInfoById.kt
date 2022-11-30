package com.gerasimov.domain.companyById

import com.gerasimov.data.data.Resource
import com.gerasimov.domain.companyById.data.CompanyInfo
import com.gerasimov.domain.companyById.model.CompanyInfoRepository

class GetCompanyInfoById(private val companyInfoRepository: CompanyInfoRepository) {
    suspend fun execute(id: Int): Resource<CompanyInfo> {
        return companyInfoRepository.getCompanyInfoById(id)
    }
}