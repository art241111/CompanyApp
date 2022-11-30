package com.gerasimov.data.companyInfo.repository

import com.gerasimov.data.companyInfo.storage.CompanyInfoStorage
import com.gerasimov.data.data.Resource
import com.gerasimov.domain.companyById.data.CompanyInfo
import com.gerasimov.domain.companyById.model.CompanyInfoRepository
import com.gerasimov.domain.getInternetStatus.data.InternetStatus

class CompanyInfoRepositoryImpl(
    private val getInternetStatus: () -> InternetStatus,
    private val remoteCompanyInfoStorage: CompanyInfoStorage,
    private val localCompanyInfoStorage: CompanyInfoStorage
) :
    CompanyInfoRepository {
    override suspend fun getCompanyInfoById(id: Int): Resource<CompanyInfo> {
        val company = if (getInternetStatus() == InternetStatus.CONNECT) {
            remoteCompanyInfoStorage.getById(id)
        } else {
            localCompanyInfoStorage.getById(id)
        }

        return Resource(
            status = company.status,
            data = if (company.data != null)
                CompanyInfo(
                    id = company.data!!.id,
                    name = company.data!!.name,
                    description = company.data!!.description,
                    imageUrl = "https://lifehack.studio/test_task/${company.data!!.img}"
                )
            else null,
            message = company.message
        )

    }
}