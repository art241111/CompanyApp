package com.gerasimov.data.companiesList.storage.retrofit

import android.util.Log
import com.gerasimov.data.api.RetrofitBuilder
import com.gerasimov.data.companiesList.storage.CompaniesListStorage
import com.gerasimov.data.companiesList.storage.data.Companies
import com.gerasimov.data.companiesList.storage.data.CompanyInList
import com.gerasimov.data.companiesList.storage.retrofit.entity.CompaniesFromLifehack
import com.gerasimov.data.data.Resource
import com.gerasimov.data.data.Status

class RetrofitCompaniesListStorage(
) : CompaniesListStorage {

    override suspend fun getList(): Resource<Companies> {
        return try {
            Resource(
                status = Status.SUCCESS,
                data = Companies(
                    getListFromLifeHack(
                    ).getCompanies().map {
                        CompanyInList(
                            id = it.id,
                            image = it.image,
                            name = it.name
                        )
                    }
                ),
                message = null
            )
        } catch (e: Exception) {
            Log.e("CompanyListErr", e.message ?: "null")
            Resource(
                status = Status.ERROR,
                data = null,
                message = e.message
            )
        }
    }

    private fun getListFromLifeHack(

    ): CompaniesFromLifehack =
        RetrofitBuilder.getRetrofit(
            "${RetrofitBuilder.LIFE_HACK_URL}/"
        ).create(CompaniesFromLifehack::class.java)
}