package com.gerasimov.companyapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.gerasimov.companyapp.viewModel.CompanyInfoViewModel
import com.gerasimov.companyapp.views.ImageView
import com.gerasimov.domain.getInternetStatus.data.InternetStatus

@Composable
fun CompanyInfoScreen(
    onReturnToList: () -> Unit,
    viewModel: CompanyInfoViewModel
) {
    val companyInfo by viewModel.companyInfo.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()
    val internetStatus by viewModel.internetStatus.collectAsState()
    Box {
        LazyColumn() {
            item {
                if (internetStatus == InternetStatus.DISCONNECT) {
                    Box(Modifier.background(Color.Red)) {
                        Text("Нет подключения к интернету")
                    }
                }
            }
            if (companyInfo != null) {
                item {
                    ImageView(imageUrl = companyInfo!!.imageUrl)
                }
                item {
                    Text(
                        text = companyInfo!!.name
                    )
                    Text(
                        text = companyInfo!!.description
                    )
                }

            } else {
                item {
                    if (errorMessage != null) {
                        Text(text = errorMessage!!)
                    }
                }
            }
        }
        IconButton(onClick = onReturnToList) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
        }
    }
}