package com.gerasimov.companyapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gerasimov.data.companyInfo.repository.CompanyInfoRepositoryImpl
import com.gerasimov.data.companyInfo.storage.retrofit.RetrofitCompanyInfoStorage
import com.gerasimov.data.companyInfo.storage.room.RoomCompanyInfoStorage
import com.gerasimov.data.internetStatus.InternetStatusRepositoryImpl
import com.gerasimov.domain.companyById.GetCompanyInfoById
import com.gerasimov.domain.companyById.data.CompanyInfo
import com.gerasimov.domain.companyById.model.CompanyInfoRepository
import com.gerasimov.domain.getInternetStatus.data.InternetStatus
import com.gerasimov.domain.getInternetStatus.model.InternetStatusRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CompanyInfoViewModel(application: Application) : AndroidViewModel(application) {
    private var _companyInfo: MutableStateFlow<CompanyInfo?> = MutableStateFlow(null)
    val companyInfo: StateFlow<CompanyInfo?> = _companyInfo

    private val retrofitCompanyInfoStorage = RetrofitCompanyInfoStorage()
    private val roomCompanyInfoStorage = RoomCompanyInfoStorage()

    private val internetRepository: InternetStatusRepository =
        InternetStatusRepositoryImpl(getApplication<Application>().applicationContext)

    private var _internetStatus: MutableStateFlow<InternetStatus> =
        MutableStateFlow(internetRepository.getInternetStatus())
    val internetStatus: StateFlow<InternetStatus> = _internetStatus

    private val repository: CompanyInfoRepository =
        CompanyInfoRepositoryImpl(
            { internetRepository.getInternetStatus() },
            retrofitCompanyInfoStorage,
            roomCompanyInfoStorage
        )

    private val getCompanyInfo = GetCompanyInfoById(repository)

    private var _errorMessage: MutableStateFlow<String?> =
        MutableStateFlow(null)
    val errorMessage: StateFlow<String?> = _errorMessage


    fun getCompanyInfoById(id: Int) {
        viewModelScope.launch {
            _internetStatus.value = internetRepository.getInternetStatus()

            with(getCompanyInfo.execute(id)) {
                _companyInfo.value = data
                _errorMessage.value = message
            }
        }
    }
}