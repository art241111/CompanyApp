package com.gerasimov.companyapp.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gerasimov.companyapp.viewModel.CompanyInfoViewModel
import com.gerasimov.companyapp.viewModel.NavigationViewModel

@Composable
fun NavigationScreen(
    viewModel: NavigationViewModel = viewModel(),
    companyInfoViewModel: CompanyInfoViewModel = viewModel()
) {
    val id by viewModel.id.collectAsState()
    if (id == -1) {
        CompanyListScreen(
            onSelectCompany = { id ->
                viewModel.getClientIndo(id)
                companyInfoViewModel.getCompanyInfoById(id)
            }
        )
    } else {
        CompanyInfoScreen(
            onReturnToList = {
                viewModel.returnToList()
            },
            companyInfoViewModel
        )
    }
}