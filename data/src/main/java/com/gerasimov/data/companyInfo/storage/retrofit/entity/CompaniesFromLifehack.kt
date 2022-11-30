package com.gerasimov.data.companyInfo.storage.retrofit.entity

import com.gerasimov.data.companyInfo.storage.retrofit.data.CompanyRetrofit
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 * @author Created by Artem Gerasimov (gerasimov.av.dev@gmail.com).
 */

interface CompanyFromLifehack {
    @GET("test.php")
    suspend fun getCompany(
        @Query("id")
        id: Int,
    ): List<CompanyRetrofit>
}
