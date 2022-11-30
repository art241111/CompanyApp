package com.gerasimov.companyapp.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NavigationViewModel : ViewModel() {
    private val _id = MutableStateFlow(-1)
    val id: StateFlow<Int> = _id

    fun getClientIndo(id: Int) {
        _id.value = id
    }

    fun returnToList() {
        _id.value = -1
    }
}