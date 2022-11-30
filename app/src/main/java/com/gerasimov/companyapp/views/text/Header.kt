package com.gerasimov.companyapp.views.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Header(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text,
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 35.sp,
        modifier = modifier
    )
}