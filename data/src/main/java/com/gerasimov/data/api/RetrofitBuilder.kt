package com.gerasimov.data.api

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Creating a retrofit instance to work with the API.
 *
 * @author Created by Artem Gerasimov (gerasimov.av.dev@gmail.com).
 */

object RetrofitBuilder {
    const val LIFE_HACK_URL = "https://lifehack.studio/test_task/"

    /**
     * Creating a retrofit instance with certain parameters.
     *
     * @param context -the context is required to obtain system
     * information about the network connection.
     * @param onConnectFailed - a function that is performed when there is no Internet access.
     * @param onConnectSuccess - a function that is performed when there is Internet access.
     * @param url - the base url that retrofit will work with
     */
    fun getRetrofit(
        context: Context,
        onConnectFailed: () -> Unit,
        onConnectSuccess: () -> Unit,
        url: String
    ): Retrofit {
        val oktHttpClient = OkHttpClient.Builder()

        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(oktHttpClient.build())
            .build()
    }
}
