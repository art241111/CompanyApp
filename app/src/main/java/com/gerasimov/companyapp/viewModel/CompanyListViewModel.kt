package com.gerasimov.companyapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gerasimov.data.companiesList.repository.CompaniesListRepositoryImpl
import com.gerasimov.data.companiesList.storage.retrofit.RetrofitCompaniesListStorage
import com.gerasimov.data.companiesList.storage.room.RoomCompaniesListStorage
import com.gerasimov.data.internetStatus.InternetStatusRepositoryImpl
import com.gerasimov.domain.companiesList.GetCompaniesList
import com.gerasimov.domain.companiesList.data.CompaniesList
import com.gerasimov.domain.companiesList.model.CompaniesListRepository
import com.gerasimov.domain.getInternetStatus.data.InternetStatus
import com.gerasimov.domain.getInternetStatus.model.InternetStatusRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CompanyListViewModel(application: Application) : AndroidViewModel(application) {
    private var _companyList: MutableStateFlow<CompaniesList?> =
        MutableStateFlow(null)
    val companyList: StateFlow<CompaniesList?> = _companyList

    private val internetRepository: InternetStatusRepository =
        InternetStatusRepositoryImpl(getApplication<Application>().applicationContext)
    private var _internetStatus: MutableStateFlow<InternetStatus> =
        MutableStateFlow(internetRepository.getInternetStatus())
    val internetStatus: StateFlow<InternetStatus> = _internetStatus

    private val retrofitCompaniesListStorage =
        RetrofitCompaniesListStorage()
    private val roomCompaniesListStorage =
        RoomCompaniesListStorage(getApplication<Application>().applicationContext)

    private val repository: CompaniesListRepository =
        CompaniesListRepositoryImpl(
            { internetRepository.getInternetStatus() },
            retrofitCompaniesListStorage,
            roomCompaniesListStorage,
            roomCompaniesListStorage
        )

    private val getCompaniesList = GetCompaniesList(repository)

    private val _isInternet = MutableStateFlow(true)
    private val isInternet: StateFlow<Boolean> = _isInternet

    init {
        getCompanyList()
    }

    private var _errorMessage: MutableStateFlow<String?> =
        MutableStateFlow(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun getCompanyList() {
        viewModelScope.launch(Dispatchers.IO) {
            _internetStatus.value = internetRepository.getInternetStatus()


            with(getCompaniesList.execute()) {
                _companyList.value = data
                _errorMessage.value = message
            }
        }

    }
}