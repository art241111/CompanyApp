package com.gerasimov.domain.companiesList.model

import com.gerasimov.data.data.Resource
import com.gerasimov.domain.companiesList.data.CompaniesList

interface CompaniesListRepository {
    suspend fun getCompaniesList(): Resource<CompaniesList>
}