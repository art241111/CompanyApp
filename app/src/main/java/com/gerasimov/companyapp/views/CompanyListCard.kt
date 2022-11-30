package com.gerasimov.companyapp.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompanyListCard(
    companyName: String,
    imgUrl: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .size(140.dp, 190.dp)
            .padding(16.dp),
        shape = RoundedCornerShape(20.dp),
        onClick = onClick,
    ) {
        Column() {
            Card(
                modifier = Modifier.size(162.dp, 105.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
                ImageView(imageUrl = imgUrl)
            }
            Spacer(modifier = Modifier.height(7.dp))

            Text(
                text = companyName,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}