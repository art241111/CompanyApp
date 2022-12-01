package com.gerasimov.companyapp.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gerasimov.companyapp.views.text.Header
import com.gerasimov.companyapp.views.text.TextWithIcon
import com.gerasimov.domain.companyById.data.CompanyInfo

@Composable
fun CompanyInfoCard(
    companyInfo: CompanyInfo,
    modifier: Modifier = Modifier
) {
    with(companyInfo) {
        Box(modifier.padding(top = 260.dp)) {
            Card(
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background),
                shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp)
            ) {
                Column(Modifier.padding(horizontal = 16.dp)) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Header(text = name)


                    if (phone.trim() != "" || webSite.trim() != "") {
                        Spacer(modifier = Modifier.height(16.dp))

                        if (phone != "") {
                            TextWithIcon(
                                icon = Icons.Default.Phone,
                                text = phone
                            )
                        }
                        if (webSite != "") {
                            TextWithIcon(
                                icon = Icons.Default.Info,
                                text = webSite
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))

                    }
                    Text(
                        text = description
                    )
                }
            }
        }
    }
}