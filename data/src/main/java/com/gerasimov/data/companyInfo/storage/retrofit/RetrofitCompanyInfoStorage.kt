package com.gerasimov.data.companyInfo.storage.retrofit

import android.util.Log
import com.gerasimov.data.api.RetrofitBuilder
import com.gerasimov.data.companyInfo.storage.CompanyInfoStorage
import com.gerasimov.data.companyInfo.storage.data.Company
import com.gerasimov.data.companyInfo.storage.retrofit.entity.CompanyFromLifehack
import com.gerasimov.data.data.Resource
import com.gerasimov.data.data.Status

class RetrofitCompanyInfoStorage(
) : CompanyInfoStorage {
    override suspend fun getById(id: Int): Resource<Company> {
        return try {
            Resource(
                status = Status.SUCCESS,
                data = getListFromLifeHack().getCompany(id + 1)[0],
                message = null
            )

        } catch (e: Exception) {
            Log.e("CompanyInfoErr", e.message ?: "null")
            Resource(
                status = Status.ERROR,
                data = null,
                message = e.message
            )
        }
    }

    private fun getListFromLifeHack(
    ): CompanyFromLifehack =
        RetrofitBuilder.getRetrofit(
            "${RetrofitBuilder.LIFE_HACK_URL}/"
        ).create(CompanyFromLifehack::class.java)


}