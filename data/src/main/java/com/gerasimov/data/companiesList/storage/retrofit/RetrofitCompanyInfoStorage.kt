package com.gerasimov.data.companiesList.storage.retrofit

import android.content.Context
import android.util.Log
import com.gerasimov.data.api.RetrofitBuilder
import com.gerasimov.data.companiesList.storage.CompaniesListStorage
import com.gerasimov.data.companiesList.storage.data.Companies
import com.gerasimov.data.companiesList.storage.retrofit.entity.CompaniesFromLifehack
import com.gerasimov.data.data.Resource
import com.gerasimov.data.data.Status

class RetrofitCompaniesListStorage(
    private val context: Context,
    private val onConnectFailed: () -> Unit,
    private val onConnectSuccess: () -> Unit,
) : CompaniesListStorage {

    override suspend fun getList(): Resource<Companies> {
        return try {
            Resource(
                status = Status.SUCCESS,
                data = Companies(
                    getListFromLifeHack(
                        context,
                        onConnectFailed,
                        onConnectSuccess
                    ).getCompanies()
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
        context: Context,
        onConnectFailed: () -> Unit,
        onConnectSuccess: () -> Unit
    ): CompaniesFromLifehack =
        RetrofitBuilder.getRetrofit(
            context,
            onConnectFailed,
            onConnectSuccess,
            "${RetrofitBuilder.LIFE_HACK_URL}/"
        ).create(CompaniesFromLifehack::class.java)
}