package com.gerasimov.companyapp.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BackArrowButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Box(modifier.padding(24.dp)) {
        Card(Modifier.size(40.dp), shape = RoundedCornerShape(15.dp)) {
            IconButton(onClick = onClick) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        }
    }
}