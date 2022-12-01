package com.gerasimov.companyapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gerasimov.companyapp.viewModel.CompanyInfoViewModel
import com.gerasimov.companyapp.views.BackArrowButton
import com.gerasimov.companyapp.views.CompanyInfoCard
import com.gerasimov.companyapp.views.ImageView
import com.gerasimov.companyapp.views.InternetError
import com.gerasimov.domain.getInternetStatus.data.InternetStatus

@Composable
fun CompanyInfoScreen(
    onReturnToList: () -> Unit, viewModel: CompanyInfoViewModel
) {
    val companyInfo by viewModel.companyInfo.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()
    val internetStatus by viewModel.internetStatus.collectAsState()
    Box {
        LazyColumn() {
            if (companyInfo != null) {
                item {
                    Box {
                        ImageView(
                            imageUrl = companyInfo!!.imageUrl,
                            modifier = Modifier.size(444.dp, 311.dp)
                        )
                        CompanyInfoCard(companyInfo!!)
                    }
                }
            } else {
                item {
                    if (errorMessage != null) {
                        Spacer(modifier = Modifier.height(200.dp))
                        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Text(text = errorMessage!!)
                        }
                    }
                }
            }
        }
        BackArrowButton {
            onReturnToList()
        }

        if (internetStatus == InternetStatus.DISCONNECT) {
            InternetError(Modifier.align(Alignment.TopCenter))
        }
    }
}