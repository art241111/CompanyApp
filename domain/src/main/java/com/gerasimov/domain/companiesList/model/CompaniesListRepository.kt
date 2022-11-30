package com.gerasimov.domain.companiesList.model

import com.gerasimov.domain.companiesList.data.CompaniesList

interface CompaniesListRepository {
    suspend fun getCompaniesList(): CompaniesList
}