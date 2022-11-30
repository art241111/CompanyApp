package com.gerasimov.data.api

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
     * @param url - the base url that retrofit will work with
     */
    fun getRetrofit(
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
