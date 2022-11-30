package com.gerasimov.domain.companiesList

import com.gerasimov.data.data.Resource
import com.gerasimov.domain.companiesList.data.CompaniesList
import com.gerasimov.domain.companiesList.model.CompaniesListRepository

class GetCompaniesList(private val companyListRepository: CompaniesListRepository) {
    suspend fun execute(): Resource<CompaniesList> {
        return companyListRepository.getCompaniesList()
    }
}