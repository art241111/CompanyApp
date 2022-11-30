package com.gerasimov.data.companyInfo.repository

import com.gerasimov.data.companyInfo.storage.CompaniesInfoStorageSavable
import com.gerasimov.data.companyInfo.storage.CompanyInfoStorage
import com.gerasimov.data.data.Resource
import com.gerasimov.domain.companyById.data.CompanyInfo
import com.gerasimov.domain.companyById.model.CompanyInfoRepository
import com.gerasimov.domain.getInternetStatus.data.InternetStatus

class CompanyInfoRepositoryImpl(
    private val getInternetStatus: () -> InternetStatus,
    private val remoteCompanyInfoStorage: CompanyInfoStorage,
    private val localCompanyInfoStorage: CompanyInfoStorage,
    private val savableStorage: CompaniesInfoStorageSavable
) :
    CompanyInfoRepository {
    override suspend fun getCompanyInfoById(id: Int): Resource<CompanyInfo> {
        val company = if (getInternetStatus() == InternetStatus.CONNECT) {
            val c = remoteCompanyInfoStorage.getById(id)
            if (c.data != null) {
                savableStorage.saveCompany(c.data!!)
            }
            c
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
                    imageUrl = "https://lifehack.studio/test_task/${company.data!!.img}",
                    lat = company.data!!.lat,
                    lon = company.data!!.lon,
                    phone = company.data!!.phone,
                    webSite = company.data!!.webSite,
                )
            else null,
            message = company.message
        )

    }
}