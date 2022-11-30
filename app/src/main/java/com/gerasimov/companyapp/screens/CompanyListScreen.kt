package com.gerasimov.companyapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gerasimov.companyapp.viewModel.CompanyListViewModel
import com.gerasimov.companyapp.views.CompanyListCard
import com.gerasimov.domain.getInternetStatus.data.InternetStatus

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompanyListScreen(
    onSelectCompany: (id: Int) -> Unit,
    viewModel: CompanyListViewModel = viewModel()
) {
    val companies by viewModel.companyList.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()
    val internetStatus by viewModel.internetStatus.collectAsState()
    Box() {
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            if (companies != null) {
                itemsIndexed(companies!!.list) { id, company ->
                    CompanyListCard(
                        companyName = company.name,
                        imgUrl = company.image
                    ) {
                        onSelectCompany(id)
                    }
                }
            } else {
                item {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        if (errorMessage != null) {
                            Text(text = errorMessage!!)
                        }
                    }
                }
            }
        }
        if (internetStatus == InternetStatus.DISCONNECT) {
            Box(Modifier.background(Color.Red)) {
                Text("Нет подключения к интернету")
            }
        }
    }
}