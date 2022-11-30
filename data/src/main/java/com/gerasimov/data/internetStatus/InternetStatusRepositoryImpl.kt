package com.gerasimov.data.internetStatus

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.gerasimov.domain.getInternetStatus.data.InternetStatus
import com.gerasimov.domain.getInternetStatus.model.InternetStatusRepository

class InternetStatusRepositoryImpl(
    private val context: Context
) : InternetStatusRepository {
    override fun getInternetStatus(): InternetStatus {
        return if (isNetworkAvailable(context)) InternetStatus.CONNECT else InternetStatus.DISCONNECT
    }

    private fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // For 29 api or above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                    ?: return false
            return when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }
        }
        // For below 29 api
        else {
            if (connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo!!.isConnectedOrConnecting) {
                return true
            }
        }
        return false
    }
}