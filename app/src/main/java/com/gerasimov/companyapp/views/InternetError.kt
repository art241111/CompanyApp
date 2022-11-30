package com.gerasimov.companyapp.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gerasimov.companyapp.ui.theme.ErrorColor

@Composable
fun InternetError(modifier: Modifier = Modifier) {
    Card(modifier.padding(20.dp), colors = CardDefaults.cardColors(containerColor = ErrorColor)) {
        Text(
            text = "Нет подключения к интернету",
            modifier = Modifier.padding(10.dp),
            color = Color.White
        )
    }
}