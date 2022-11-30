package com.gerasimov.data.companyInfo.storage.retrofit

import android.content.Context
import android.util.Log
import com.gerasimov.data.api.RetrofitBuilder
import com.gerasimov.data.companyInfo.storage.CompanyInfoStorage
import com.gerasimov.data.companyInfo.storage.data.Company
import com.gerasimov.data.companyInfo.storage.retrofit.entity.CompanyFromLifehack
import com.gerasimov.data.data.Resource
import com.gerasimov.data.data.Status

class RetrofitCompanyInfoStorage(
    private val context: Context,
    private val onConnectFailed: () -> Unit,
    private val onConnectSuccess: () -> Unit,
) : CompanyInfoStorage {
    override suspend fun getById(id: Int): Resource<Company> {
        return try {
            Resource(
                status = Status.SUCCESS,
                data = getListFromLifeHack(
                    context,
                    onConnectFailed,
                    onConnectSuccess
                ).getCompany(id + 1)[0],
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
        context: Context,
        onConnectFailed: () -> Unit,
        onConnectSuccess: () -> Unit
    ): CompanyFromLifehack =
        RetrofitBuilder.getRetrofit(
            context,
            onConnectFailed,
            onConnectSuccess,
            "${RetrofitBuilder.LIFE_HACK_URL}/"
        ).create(CompanyFromLifehack::class.java)


}