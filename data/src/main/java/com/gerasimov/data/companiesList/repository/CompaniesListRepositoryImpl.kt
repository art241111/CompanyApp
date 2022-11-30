package com.gerasimov.data.companiesList.repository

import com.gerasimov.data.companiesList.storage.CompaniesListStorage
import com.gerasimov.data.companiesList.storage.data.Companies
import com.gerasimov.data.data.Resource
import com.gerasimov.domain.companiesList.data.CompaniesList
import com.gerasimov.domain.companiesList.data.CompaniesListEntity
import com.gerasimov.domain.companiesList.model.CompaniesListRepository
import com.gerasimov.domain.getInternetStatus.data.InternetStatus

class CompaniesListRepositoryImpl(
    private val getInternetStatus: () -> InternetStatus,
    private val remoteCompaniesListStorage: CompaniesListStorage,
    private val localCompaniesListStorage: CompaniesListStorage
) : CompaniesListRepository {

    override suspend fun getCompaniesList(): Resource<CompaniesList> {
        val companiesList: Resource<Companies> =
            if (getInternetStatus() == InternetStatus.CONNECT) {
                remoteCompaniesListStorage.getList()
            } else {
                localCompaniesListStorage.getList()
            }

        return Resource(
            status = companiesList.status,
            data = if (companiesList.data != null && companiesList.data?.list != null)
                CompaniesList(companiesList.data!!.list.map {
                    CompaniesListEntity(
                        id = it.id,
                        name = it.name,
                        image = "https://lifehack.studio/test_task/${it.image}"
                    )
                })
            else null,
            message = companiesList.message
        )

    }

}