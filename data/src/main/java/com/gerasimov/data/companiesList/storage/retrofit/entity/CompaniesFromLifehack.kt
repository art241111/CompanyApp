package com.gerasimov.data.companiesList.storage.retrofit.entity

import com.gerasimov.data.companiesList.storage.data.CompanyInList
import retrofit2.http.GET

/**
 *
 * @author Created by Artem Gerasimov (gerasimov.av.dev@gmail.com).
 */

interface CompaniesFromLifehack {
    @GET("test.php")
    suspend fun getCompanies(): List<CompanyInList>
}
