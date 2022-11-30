package com.gerasimov.domain.getInternetStatus.model

import com.gerasimov.domain.getInternetStatus.data.InternetStatus

interface InternetStatusRepository {
    fun getInternetStatus(): InternetStatus
}